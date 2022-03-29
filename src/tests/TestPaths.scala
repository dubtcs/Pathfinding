package tests

import maze.{GridLocation, MapTile}
import solver.PathFinding
import org.scalatest._

class TestPaths extends FunSuite {


     test("test path 1") {

          val level: Int = 1
          val Map: List[List[MapTile]] = TestingMaps(level).tiles

          var Path: List[GridLocation] = PathFinding.findPath(new GridLocation(5, 5), new GridLocation(8, 8), Map)
          assert(Path.length == 7)

          Path = PathFinding.findPath(new GridLocation(1,1), new GridLocation(1,2), Map)
          assert(Path.length == 2)

     }


}