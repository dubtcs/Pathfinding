package DataStructures

class Queue[A] {

     var Front: LinkedNode[A] = null
     var End: LinkedNode[A] = null

     def empty(): Boolean = {
          Front == null
     }

     def addQueue(a: A): Unit = {
          if (End == null){
               this.End = new LinkedNode[A](a, null)
               this.Front = this.End
          } else {
               this.End.Next = new LinkedNode[A](a, null)
               this.End = this.End.Next
          }
     }

     def removeQueue(): A = {
          val r = this.Front.Value
          this.Front = this.Front.Next
          if (this.Front == null){
               this.End = null
          }
          r
     }

}
