package leadrandori

object HashChain {

  def hashChain(n: BigInt): List[BigInt] = {
    if (n <= 0) Nil
    else if (n == 1) List(1)
    else {
      val previous = hashChain(n - 1)
      val newHash = previous.last * 31 + n
      previous :+ newHash
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    val result = hashChain(n)
    println(s"Hash chain of n = $n: $result")


   val candidate01 = new Candidate("c1", "Diego")
   val candidate02 = new Candidate("c2", "Dora")
   val candidates = List(candidate01, candidate02)
   val election = createElection("e1", "Presidential Election", candidates)
   println(s"Election: ${election.name}, Candidates: ${election.candidates.map(_.name).mkString(", ")}")
    val vote1 = new Vote("voter1", "c1", "e1")
    val vote2 = new Vote("voter2", "c2", "e1")
    val vote3 = new Vote("voter3", "c1", "e1")
    val vote4 = new Vote("voter4", "c2", "e1")
    val vote5 = new Vote("voter5", "c1", "e1")
    val vote6 = new Vote("voter6", "c2", "e1")
    val vote7 = new Vote("voter7", "c1", "e1")
    val vote8 = new Vote("voter8", "c2", "e1")
    val vote9 = new Vote("voter9", "c1", "e1")

    val votes = List(vote1, vote2, vote3, vote4, vote5, vote6, vote7, vote8, vote9)
    val voteHashChain = new HashChain4Votes(votes)
    val hashResults = voteHashChain.generateHashChain()
    println(s"Hash chain for votes: $hashResults")

      val winner = election.whoIsWinning(votes)
    println(s"The winner of the election is: $winner")


  }

  class Candidate(val id: String, val name: String)

  class Election(val id: String, val name: String, val candidates: List[Candidate]) {

    def whoIsWinning(votes: List[Vote]): String = {
      val voteCount = votes.groupBy(_.candidateId).mapValues(_.size)
      val winner = voteCount.maxBy(_._2)._1
      candidates.find(_.id == winner).map(_.name).getOrElse("No winner")
    }
  }

  class Vote(val voterId: String, val candidateId: String, val electionId: String) {
    def hashVote(): BigInt = {
      val data = s"$voterId-$candidateId-$electionId"
      data.hashCode.toLong
    }
  }

  class HashChain4Votes(val votes: List[Vote]) {
    def generateHashChain(): List[BigInt] = {
      votes.map(_.hashVote())
    }
  }

  def createElection(id: String, name: String, candidates: List[Candidate]): Election = {
    new Election(id, name, candidates)
  }

  def createCandidates(candidateData: List[(String, String)]): List[Candidate] = {
    candidateData.map { case (id, name) => new Candidate(id, name) }
  }




}
