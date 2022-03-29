package tests

import maze.{GridLocation, MapTile}
import play.api.libs.json.{JsValue, Json}


object TestingMaps {

  def apply(number: Int): TestingMaps ={
    if(number == 0){
      new TestingMaps{
        tiles = List(
          MapTile.generateRow("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO")
        )
        startingLocation = new GridLocation(1, 3)
      }
    }else if(number == 1) {
      new TestingMaps{
        tiles = List(
          MapTile.generateRow("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O-------------OOOO-----------O"),
          MapTile.generateRow("O---------OOOOOOOOOOO--------O"),
          MapTile.generateRow("O--------OOO------OOOOOO-----O"),
          MapTile.generateRow("O-------OO----------OOO------O"),
          MapTile.generateRow("O-------OOO----------O-------O"),
          MapTile.generateRow("O--------OO---------OOO------O"),
          MapTile.generateRow("O---------OOO-------OOO------O"),
          MapTile.generateRow("O--------------OOOOOOOOOOOO--O"),
          MapTile.generateRow("O---------OOOOOOOO-----------O"),
          MapTile.generateRow("O---------------OOOOO--------O"),
          MapTile.generateRow("O---------------OOOOO--------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("O----------------------------O"),
          MapTile.generateRow("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO")
        )

        startingLocation = new GridLocation(15, 10)

      }
    }else{
      new TestingMaps
    }
  }

}
class TestingMaps {
  var tiles:List[List[MapTile]] = List()
  var startingLocation = new GridLocation(0, 0)

  def tilesJSON(): JsValue = {
    Json.toJson(tiles.map((row: List[MapTile]) => row.map((tile: MapTile) => Json.toJson(Map("type" -> Json.toJson(tile.tileType), "passable" -> Json.toJson(tile.passable))))))
  }

}
