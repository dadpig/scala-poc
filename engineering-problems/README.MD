## Architectural Goals

* Exactly-once logical vote processing
* Zero vote loss under retries and poor connectivity
* Strong integrity and tamper detection
* Independent scalability of writes and reads
* Deterministic replay and recount capability
* Full operational control (no Lambdas)

---

## Amazon MSK (Managed Stream Kafka) record for vote events write-once event log.
Kafka absorbs spikes, preserves history, and enables deterministic reprocessing. DynamoDB is never written to directly by clients.

### Key Characteristics

* Idempotent producers enabled
* Transactional writes
* Strict ordering per partition
* Long retention for replay and audit

### Guarantees

* Vote events are append-only
* Retries do not create duplicates
* Atomic multi-topic writes (vote + audit)

---

## DynamoDB Write Cluster
Stores immutable, confirmed votes.

### Design Principles

* Write-only access pattern
* No updates or deletes
* Conditional writes enforced
* Chain hash for integrity

### Key Design

* **Partition Key (PK)**: `ELECTION#{election_id}`
* **Sort Key (SK)**: `VOTE#{sequence_number}`

Each vote includes:

* Vote payload (candidate, region)
* Previous hash
* Current hash
* Kafka offset reference

### Chain Hash Strategy

Each vote cryptographically links to the previous one:

```
currentHash = SHA256(voteData + prevHash)
```

This creates a tamper-evident, append-only chain similar to a blockchain log, without consensus overhead.

---

## DynamoDB Read Cluster (Query / Read Model – CQRS)

### Purpose

Serves high-volume reads such as:

* Real-time vote counts
* Regional aggregates
* Dashboards and reporting

### Characteristics

* Separate tables / capacity from write cluster
* Fully derived state
* Can be dropped and rebuilt at any time
* Optimized for queries, not writes

### Update Mechanism

Read models are updated asynchronously via DynamoDB Streams(KCL) consumers running in EKS.

---

## EKS Streams Consumers with KCL

### What is KCL?

The **Kinesis Client Library (KCL)** is a distributed consumption framework used to process shard-based streams (Kinesis or DynamoDB Streams).

In this architecture, KCL is used to:

* Consume DynamoDB Streams
* Coordinate shard ownership
* Manage checkpoints
* Handle failover and rebalancing

### Why KCL on EKS?

* Full control over lifecycle and scaling
* Deterministic shard-to-pod assignment
* No serverless execution model

### Scaling Model

* One active consumer per shard
* Autoscaling based on shard count and iterator lag
* No CPU-based scaling

---