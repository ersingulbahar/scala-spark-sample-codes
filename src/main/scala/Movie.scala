class Movie(var movieId: String, var title: String, var genres: String) extends
  Serializable{
  // Overriding tostring method
  override def toString(): String = {
    return "[Id : " + movieId + ", Title = " + title + " Genre = " + genres + " ]"
  }
}