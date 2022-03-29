package DataStructures

class LinkedNode[A](var Value: A, var Next: LinkedNode[A]) {

     def add(a: A): LinkedNode[A] = {
          new LinkedNode[A](a, this)
     }

}
