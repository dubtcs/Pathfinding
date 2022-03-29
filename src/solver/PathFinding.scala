package solver

import maze.{GridLocation, MapTile, PhysicsVector}
import DataStructures._

object PathFinding {

     def findPath(Start: GridLocation, End: GridLocation, MyMap: List[List[MapTile]]): List[GridLocation] = {

          var Visited: List[GridLocation] = List()
          var DiscoveryMap: Map[GridLocation, GridLocation] = Map()

          var Path: List[GridLocation] = List()
          val Q: Queue[GridLocation] = new Queue[GridLocation]
          var Found: Boolean = false
          Q.addQueue(Start)

          while (!Q.empty() && !Found) {
               val Next: GridLocation = Q.removeQueue()

               val Adj: List[GridLocation] = List(
                    new GridLocation(Next.x + 1, Next.y),
                    new GridLocation(Next.x - 1, Next.y),
                    new GridLocation(Next.x, Next.y - 1),
                    new GridLocation(Next.x, Next.y + 1)
               )

               for (location <- Adj) { // Check all adjacent locations

                    if (location == End) { // The end is found

                         DiscoveryMap += (End -> Next)
                         var Back: GridLocation = End

                         Path = List(End)
                         while (Back != Start) {
                              Path = DiscoveryMap(Back) :: Path
                              Back = DiscoveryMap(Back)
                         }

                         Found = true

                    } else { // Not the end

                         // Make sure the location is accessible and not visited
                         if (MyMap.apply(location.y).apply(location.x).passable && !Visited.contains(location)) {
                              DiscoveryMap += (location -> Next)
                              Q.addQueue(location)
                              Visited = location :: Visited
                         }

                    }
               }

          }

          Path

     }

     def getVelocity(Path: List[GridLocation], CurrentLocation: PhysicsVector): PhysicsVector = {

          if (Path.nonEmpty){
               val Tile: GridLocation = new GridLocation(math.floor(CurrentLocation.x).toInt, math.floor(CurrentLocation.y).toInt)
               val Vector: PhysicsVector = new PhysicsVector(CurrentLocation.x,CurrentLocation.y)
               val Distance: Double = new PhysicsVector(Path.last.x + 0.5, Path.last.y + 0.5).distance2d(Vector)
               val NextTile: GridLocation = if(Tile == Path.last){
                    Path.last
               } else {
                    Path(Path.indexOf(Tile) + 1)
               }
               if (Tile == Path.last && Distance < 0.1){
                    new PhysicsVector(0,0)
               } else {
                    var UnitVector: PhysicsVector = new PhysicsVector(NextTile.x + 0.5, NextTile.y + 0.5)
                    UnitVector = new PhysicsVector(UnitVector.x - CurrentLocation.x, UnitVector.y - CurrentLocation.y).normal2d()
                    UnitVector = new PhysicsVector(UnitVector.x * 5, UnitVector.y * 5)
                    UnitVector
               }
          } else {
               new PhysicsVector(0,0)
          }

          /*
          if (Path.nonEmpty) {

               val Tile: GridLocation = new GridLocation(math.floor(CurrentLocation.x).toInt, math.floor(CurrentLocation.y).toInt)
               val NextTile: GridLocation = if (Tile != Path.last){
                    Path(Path.indexOf(Tile) + 1)
               } else {
                    Path.last
               }

               val Vector: PhysicsVector = new PhysicsVector(CurrentLocation.x,CurrentLocation.y)
               val NextVector: PhysicsVector = new PhysicsVector(NextTile.x + 0.5, NextTile.y + 0.5)

               val Distance: Double = NextVector.distance2d(Vector)

               val ReturnVector: PhysicsVector = if (Tile == Path(Path.indexOf(Path.last) - 1) && Distance < 0.1){
                    new PhysicsVector(0,0)
               } else {
                    var UnitVector: PhysicsVector = new PhysicsVector(NextVector.x - CurrentLocation.x, NextVector.y - CurrentLocation.y).normal2d()
                    UnitVector = new PhysicsVector(UnitVector.x * 5, UnitVector.y * 5)
                    UnitVector
               }

               ReturnVector

               /*
               val Tile: GridLocation = new GridLocation(math.floor(CurrentLocation.x).toInt, math.floor(CurrentLocation.y).toInt)
               val NextVector: PhysicsVector = new PhysicsVector()
               val NextTile: GridLocation = if (Tile == Path.last) {
                    if () {
                         return new PhysicsVector(0, 0)
                    }
                    Path.last
               } else {
                    Path(Path.indexOf(Tile) + 1)
               }
               var UnitVector: PhysicsVector = new PhysicsVector(NextTile.x + 0.5 - CurrentLocation.x, NextTile.y + 0.5 - CurrentLocation.y).normal2d()
               UnitVector = new PhysicsVector(UnitVector.x * 5, UnitVector.y * 5)

               UnitVector
               */
               
          } else {
               new PhysicsVector(0, 0)
          }
          */

     }

}
