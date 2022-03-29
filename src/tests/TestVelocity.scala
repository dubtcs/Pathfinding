package tests

import maze.{GridLocation, PhysicsVector}
import solver.PathFinding
import org.scalatest.FunSuite

class TestVelocity extends FunSuite {

     val EPSILON: Double = 0.01

     def equalDoubles(d1: Double, d2: Double): Boolean = {
          (d1 - d2).abs < EPSILON
     }

     def equalsVectors(v1: PhysicsVector, v2: PhysicsVector): Boolean = {
          equalDoubles(v1.x, v2.x) && equalDoubles(v1.y, v2.y) && equalDoubles(v1.z, v2.z)
     }


     test("test pathToDirection 1") {

          var Path: List[GridLocation] = List( new GridLocation(1,2), new GridLocation(2,2), new GridLocation(3,2))
          var Location: PhysicsVector = new PhysicsVector(1.5,2.5)

          var v: PhysicsVector = PathFinding.getVelocity(Path,Location)
          assert(equalDoubles(v.x,5))
          assert(equalDoubles(v.y,0))

          Path = List( new GridLocation(11,12), new GridLocation(10,12), new GridLocation(9,12), new GridLocation(9,13), new GridLocation(9,14), new GridLocation(110,14))
          Location = new PhysicsVector(9.55,14.1)

          v = PathFinding.getVelocity(Path,Location)
          assert(equalDoubles(v.x,5))
          assert(equalDoubles(v.y,0.02))

          Path = List( new GridLocation(1,2), new GridLocation(2,3), new GridLocation(3,3))
          Location = new PhysicsVector(2.9,3.5)

          v = PathFinding.getVelocity(Path,Location)
          assert(equalDoubles(v.x,5))
          assert(equalDoubles(v.y,0))

     }


}
