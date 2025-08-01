object FileMatcher:
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean =
    for file <- filesHere if matcher(file.getName)
      yield file

  def filesEnding(query: String) =
    filesMatching(_endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) = 
    filesMatching(_.matches(query))


FileMatcher.filesEnding(".scala")// return all files ending with '.scala'
FileMatcher.filesContaining("Match") // return 'FileMatcher.scala'

    
