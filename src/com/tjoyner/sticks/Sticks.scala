package com.tjoyner.sticks

object Sticks {
  def main(args : Array[String]) : Unit = {
	//var tmp=new Sticks()
    //val am = CanonicalMove.allMoves
    //am foreach println
    //val am = Move.allMoves
    //am foreach println
    //am foreach (m => println(m + " " + tmp.canonicalMove(m)))
  //return
	  val r = List(
                 List(false), 
                 List(false, false, false), 
                 List(false, false, false, false, false),
                 List(false, false, false, false, false, false, false)
                 )
	  var s=new Sticks(r)
      //println(s.canonicalMove(Move(3,2,4)))
      //return
	   //LetsPlay.p1 = LetsPlay.randomMove
	   //LetsPlay.p2 = LetsPlay.cannedStrategy
	   //LetsPlay.p2 = LetsPlay.humanMove
	   //LetsPlay.p1 = LetsPlay.cannedStrategy
	   //LetsPlay.p1 = LetsPlay.cannedStrategy
	   //LetsPlay.p2 = LetsPlay.randomMove
	   LetsPlay.p1 = LetsPlay.autoMoveP1
	   LetsPlay.p2 = LetsPlay.autoMoveP2
	   for (i <- 1 to 1000000) {
          //println("Game " + i + "********************************************************")
	  	   val l2 = LetsPlay.play(s)
           //println(LetsPlay.p2BestMoves)
           //println(LetsPlay.p2BestMoves.toString("2-3"))
           if (i > 990000) {
            if (LetsPlay.p1Won) {
                println("################################################")
                l2 foreach ( x => 
                  {
                    println(x)
                    println(x.nextMove)
		            val pm = LetsPlay.p2BestMoves.possibleMoves(x)
                    println ("sorted p2 pm=" + pm)
	                println ("Best move would be" + LetsPlay.p2BestMoves.bestMove(x)._1)
	                println ("Best p1 move would be" + LetsPlay.p1BestMoves.bestMove(x)._1)
	                println ("Actual move would be" + x.nextMove)
                    var fnd = false
                    for (cm <- pm) {
                    if (!fnd) {
                    println ("trying=" + cm)
                        val em = s.findEquivalentMove(cm._1)
                    println ("trying em=" + em)
                        em match {
                          case Some(m) => if (s.validMove(m))  {println(em + " is valid "); fnd=true}
                          case None => println("em " + em + " not valid.")
                        }
                      }
                    }
                    println(LetsPlay.p2BestMoves.toString(x.canonical())) 
                  }
                  )
                //l2 foreach ( println(LetsPlay.p2BestMoves.toString(_.canonical())) )
                return
            }
           }
           if (i % 1000 == 0) println("Results after " + i +" games: " + LetsPlay.results)
           // println("Results after " + i +" moves: " + LetsPlay.results)
            //l2 foreach println
            //timesout
       }
            println("Results: " + LetsPlay.results)
            return
       LetsPlay.p1Wins = 0
       LetsPlay.p2Wins = 0
	   LetsPlay.p1 = LetsPlay.humanMove
	   for (i <- 1 to 2) {
	  	   val l2 = LetsPlay.play(s)
                l2 foreach ( x => 
                    {
                    println(x)
                    println(x.nextMove)
                  }
                  )
       }
            return
       LetsPlay.p1Wins = 0
       LetsPlay.p2Wins = 0
	   LetsPlay.p1 = LetsPlay.autoMoveP1
	   LetsPlay.p2 = LetsPlay.autoMoveP2
	   for (i <- 1 to 100000) {
	  	   val l2 = LetsPlay.play(s)
           //println("Results after " + i +" moves: " + BestMoves.results)
           if (i % 1000 == 0) println("Results after " + i +" moves: " + LetsPlay.results)
 //          if (l2.head.nextMove == Move(2,0,1) || l2.head.nextMove == Move(2,3,1) ) {
  //           val next = l2.tail.tail.head
   //          if (next.nextMove == Move(1,0,1) || next.nextMove == Move(1,2,1)) {
//               println("\n\n***********************************")
//               l2 foreach (s =>s.print)
//               println("Results after " + i +" moves: " + BestMoves.results)
//               try { readInt } catch { case _ => println("bad number") }
             //}
           //}
       }
       return
       LetsPlay.p1Wins = 0
       LetsPlay.p2Wins = 0
	   LetsPlay.p1 = LetsPlay.autoMoveP1

      /*
      var m = Move(0,0,1)
      var me = s.findEquivalentMove(3, 1)
      println("Move: " + m + " equiv: " + me);
      me = s.findEquivalentMove(4, 1)
      println("Move: " + m + " equiv: " + me);
      m = Move(4,0,4)
      me = s.findEquivalentMove(4, 4)
      println("Move: " + m + " equiv: " + me);
      m = Move(4,0,5)
      me = s.findEquivalentMove(5, 5)
      println("Move: " + m + " equiv: " + me);
      */
//	   LetsPlay.p2 = LetsPlay.humanMove
	   
	   /*
	  s = LetsPlay.humanMove(s)
	  s.print
	  */
	   //val l1 = LetsPlay.play(s)
	   for (i <- 1 to 200000) {
	  	   LetsPlay.play(s)
           //readInt
           if (i % 10000 == 0) println("Results after " + i +" moves: " + LetsPlay.results)
	   }
	   //println ("l1 Length is " + l1.length)
	  //l1 foreach (s =>s.print)
	  
	  //val s2=s1.applyMove(Move(3,2,1))
	  //s1.print()
     // val l = List(false, false, true, false, false) 
      //println (pack(l, false))
      //val am = addMoves(l,1)
      //println (packMoves(am))
      
	  //val s2=s1.applyMove(Move(3,2,1))
	  //val s2=s1.applyMove(Move(0,0,1))
	  //println("TOM s2 is " + s2.groupMoves + "xxxxxxx") 
	  //val s3=s2.applyMove(Move(1,0,2))
	  //println("TOM s3 is " + s3.groupMoves + "xxxxxxx") 
	  //val s4=s1.applyMove(Move(2,0,4))
	  //println("TOM s4 is " + s4.groupMoves + "xxxxxxx") 
	   /*
	  val m = BestMoves.bestMove(s1)._1
	  println ("m1 is " + m)
	  val s2=s1.applyMove(m)
	  println ("s2 is " + s2)
	  val m2 = BestMoves.bestMove(s2)._1
	  println ("m2 is " + m2)
	  val s3=s2.applyMove(m2)
	  s3.print
	  */
	  /*
	   for (i <- 1 to 100000) LetsPlay.play
	   println ("results: " + BestMoves.results())
	   
	   val l1 = LetsPlay.play
	   println ("l1 Length is " + l1.length)
	  l1 foreach (s =>s.print)
	   println(BestMoves.toString())
	   val l2 = LetsPlay.play
	   println ("l2 Length is " + l2.length)
	  l2 foreach (s =>s.print)
	   val l3 = LetsPlay.play
	   println ("l3 Length is " + l3.length)
	  l3 foreach (s =>s.print)
	  */
	   
	   /*
	   val l2 = LetsPlay.play
	   println ("Length is " + l2.length)
	  l2 foreach (s =>s.print)
	  */
	   
	  
      
	  /*
	  val s2=s1.applyMove(Move(0,0,1))
	  s2.print()
	  val s3=s2.applyMove(Move(1,0,1))
	  s3.print()
	  val s4=s3.applyMove(Move(3,2,1))
	  s4.print()
	  val all = Move.allMoves()
	  all foreach (m =>m.print)
	  */
	   /* 
	    *  p1: Given a starting configuration, choose "best" move
	    *  p2: Given a configuration choose a move
	    *  play until end of game
	    *  record moves in "best moves" for the game
	    *  Repeat.
	    *  
	    *  End game check:
	    *    Only one group of sticks is left
	    *    if # is 1, lose, otherwise, win.
	    */
  }

  def timesout() : Unit = {
    try { readInt } catch { case _ => "bad int" }
  }
  
  def addMoves (ls: List[Boolean], row : Int) : List[(Boolean, Move)] = {
     for (x <- ls zipWithIndex) yield (x._1, Move(row, x._2, 1))
     //println ("TOM, t is " + t)
     //t
  }
	def packMoves(ls: List[(Boolean, Move)]): List[List[(Boolean,Move)]] = {
	    if (ls.isEmpty) Nil //List(List())
	    else {
	      //val (packed, next) = ls span { _ == ls.head }
	      val (packed, next) = ls span { _._1 == false }
	      if (next == Nil) {
	     	  if (packed == Nil) Nil
	     	  else List(packed)
	      } else {
	     	  //if (packed == Nil) return Nil
	     	  val l2 = next dropWhile { _._1 == true }
	     	  if (l2 == Nil) {
	     	 	  if (packed == Nil) Nil else List(packed)
	     	  }
	     	  else { 
	     	 	  if (packed == Nil) packMoves(l2)
	     	 	  else packed :: packMoves(l2)
	     	  }
	      }
	    }
    }
	
	def pack[A, B](ls: List[A], v : B): List[List[A]] = {
	    if (ls.isEmpty) List(List())
	    else {
	      //val (packed, next) = ls span { _ == ls.head }
	      val (packed, next) = ls span { _ == v }
	      if (next == Nil) List(packed)
	      else {
	     	  val l2 = next dropWhile { _ != v }
	     	  if (l2 == Nil) List(packed)
	     	  else packed :: pack(l2, v)
	      }
	    }
    }
}


object EndGame extends Enumeration {
     type EndGame = Value
     val KeepGoing, Lost, CanWin = Value
}

import EndGame._

object LetsPlay
{
	var p1Wins = 0
	var p2Wins = 0
	def results() : (Int, Int) = {
		(p1Wins, p2Wins)
	}
    val p1BestMoves: BestMoves = new BestMoves
    val p2BestMoves: BestMoves = new BestMoves

	def autoMoveP1(s: Sticks) : Sticks = {
	  var m = p1BestMoves.bestMove(s)._1
      //println ("Automove is " + m)
	  s.applyMove(m)
	}

	def autoMoveP2(s: Sticks) : Sticks = {
      //println ("amp2 b4 " + s)
	  var m = p2BestMoves.bestMove(s)._1
	  val s2 = s.applyMove(m)
      //println ("move " + m)
      //println ("amp2 aft " + s2)
      //readInt
      s2
	}
	
	def humanMove(s: Sticks) : Sticks = {
//      val t = readf3("{integer} {integer} {integer}")
		println("Before:")
	  s.print
	 	try {
	       var m = Move(readInt, readInt, readInt)
	       val s2 =s.applyMove(m)
	       println("After:")
	       s2.print
	       return s2
	 	  } catch {
	 	 	  case _  => println("Illegal move")
	 	  }
	 	  return humanMove(s)
	}

	def randomMove(s: Sticks) : Sticks = {
		//println("Before:")
	    //s.print
		val am = Move.allMoves()
        val vm = am.filter(s.validMove(_))
        val m = removeAt((new util.Random).nextInt(vm.length), vm)._2
	    val s2 =s.applyMove(m)
	    //println("After:")
	    //s2.print
	    return s2
	}
    
    def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
      case (Nil, _) if n < 0 => throw new NoSuchElementException
      case (pre, e :: post)  => (pre ::: post, e)
      case (pre, Nil)        => throw new NoSuchElementException
    }
	
	def cannedStrategy(s: Sticks) : Sticks = {
        //println ("Before, " + s.canonical())
        //s.print
        val mo = s.canonical() match {
          case "2" => s.findEquivalentMove(2, 1)
          case "3" => s.findEquivalentMove(3, 2)
          case "4" => s.findEquivalentMove(4, 3)
          case "1-1" => s.findEquivalentMove(1, 1)
          case "1-2" => s.findEquivalentMove(2, 2)
          case "1-3" => s.findEquivalentMove(3, 3)
          case "1-4" => s.findEquivalentMove(4, 4)
          case "2-2" => s.findEquivalentMove(2, 1)
          case "2-3" => s.findEquivalentMove(3, 1)
          case "2-4" => s.findEquivalentMove(4, 2)
          case "3-3" => s.findEquivalentMove(3, 1)
          case "3-4" => s.findEquivalentMove(4, 1)
          case "1-1-1" => s.findEquivalentMove(1, 1)
          case "1-1-2" => s.findEquivalentMove(2, 1)
          case "1-1-3" => s.findEquivalentMove(3, 2)
          case "1-1-4" => s.findEquivalentMove(4, 3)
          case "1-2-2" => s.findEquivalentMove(1, 1)
          case "1-2-3" => s.findEquivalentMove(1, 1)
          case "1-2-4" => s.findEquivalentMove(4, 1)
          case "1-3-3" => s.findEquivalentMove(1, 1)
          case "1-3-4" => s.findEquivalentMove(4, 2)
          case "1-4-4" => s.findEquivalentMove(1, 1)
          case "2-2-2" => s.findEquivalentMove(2, 2)
          case "2-2-3" => s.findEquivalentMove(3, 3)
          case "2-2-4" => s.findEquivalentMove(4, 4)
          case "2-3-3" => s.findEquivalentMove(3, 2)
          case "2-3-4" => s.findEquivalentMove(4, 3)
          case "2-4-4" => s.findEquivalentMove(2, 2)
          case "3-3-3" => s.findEquivalentMove(3, 3)
          case "3-3-4" => s.findEquivalentMove(4, 4)
          case "3-4-4" => s.findEquivalentMove(3, 3)
          case "4-4-4" => s.findEquivalentMove(4, 4)
          case _ => {
            println ("move not found for " + s.canonical())
            None
          }
        }
        val m = mo.getOrElse(return humanMove(s))
        val s2 = s.applyMove(m)
        //println ("After move " + m)
        //s2.print
        s2
	}
	
	var p1 : (Sticks => Sticks) = autoMoveP1
	var p2 : (Sticks => Sticks) = autoMoveP2
	var p1Won = false
	
	def play(s : Sticks) : List[Sticks] = {
		p1Won = false
		val los = s :: makeP1Move(s)
        if (p1Won) {
            p1Wins += 1
		    p1BestMoves.addMoves(los, true, true)
		    p2BestMoves.addMoves(los, false, false)
        } else {
            p2Wins += 1
		    p1BestMoves.addMoves(los, true, false)
		    p2BestMoves.addMoves(los, false, true)
        }
		los
	}
	
	def play() : List[Sticks] = {
		play(new Sticks)
	}
	def makeP1Move(s: Sticks) : List[Sticks] = {
		//println("p1 sticks")
        //s.print
		//println("p1eg:" + s.endGame)
	  s.endGame match {
			case (a,b) if a == Lost => s.applyMove(b) :: Nil
			case (a,b) if a == KeepGoing => {
			     val s2=p1(s)
			     s2 :: makeP2Move(s2)
			}
			case (a,b) if a == CanWin => {
				val s2 = s.applyMove(b)
				//p1Won = true
     		     s2 :: makeP2Move(s2)
			}
	  }
	}
	
	def makeP2Move(s: Sticks) : List[Sticks] = {
		//println("p2 sticks")
        //s.print
		//println("p2eg:" + s.endGame)
	  s.endGame match {
			case (a,b) if a == Lost => {
              p1Won = true
              s.applyMove(b) :: Nil
            }
			case (a,b) if a == KeepGoing => {
			     val s2=p2(s)
			     s2 :: makeP1Move(s2)
			}
			case (a,b) if a == CanWin => {
				val s2 = s.applyMove(b)
     		     s2 :: makeP1Move(s2)
			}
	  }
	}
	
	/*
	def makeP1Move(s: Sticks) : List[Sticks] = {
	  val s2=p1(s)
	  println("p1s2:")
	  s2.print
	  println("p1eg" + s2.endGame)
	  s2.endGame match {
			case (a,b) if a == Lost => s2 :: s2.applyMove(b) :: Nil
			case (a,b) if a == KeepGoing => s2 :: makeP2Move(s2)
			case (a,b) if a == CanWin => {
				val s3 = s2.applyMove(b)
				p1Won = true
				s2 :: s3 :: s3.applyMove(s3.endGame._2) :: Nil
			}
	  }
		
	}
	
	def makeP2Move(s: Sticks) : List[Sticks] = {
	  val s2=p2(s)
	  //val eg = s2.endGame
	  println("p2eg" + s2.endGame)
	  s2.endGame match {
			case (a,b) if a == Lost => s2 :: s2.applyMove(b) :: Nil
			case (a,b) if a == KeepGoing => s2 :: makeP1Move(s2)
			case (a,b) if a == CanWin => {
				val s3 = s2.applyMove(b)
				s2 :: s3 :: s3.applyMove(s3.endGame._2) :: Nil
			}
	  }
	}
	*/
	
    /*
	def makeMoves(s: Sticks) : List[Sticks] = {
	  val m = BestMoves.bestMove(s)._1
	  val s2=s.applyMove(m)
	  //val eg = s2.endGame
	  s2.endGame match {
			case (a,b) if a == Lost => s2 :: s2.applyMove(b) :: Nil
			case (a,b) if a == KeepGoing => s2 :: makeMoves(s2)
			case (a,b) if a == CanWin => {
				val s3 = s2.applyMove(b)
				s2 :: s3 :: s3.applyMove(s3.endGame._2) :: Nil
			}
	  }
	}
    */
}

class BadMove extends Throwable
{
}

class Sticks (){
	def this(rowz: List[List[Boolean]]) = {
		this()
		rows = rowz
	}

	var rows : List[List[Boolean]] = List(
			                         List(false), 
			                         List(false, false, false), 
			                         List(false, false, false, false, false),
			                         List(false, false, false, false, false, false, false))
	var nextMove = Move(0, 0, 0)

    def findEquivalentMove(cm : CanonicalMove) : Option[Move] = {
        findEquivalentMove(cm.groupSize, cm.offset, cm.number)
    }
    def findEquivalentMove(sz : Int, offset: Int, number : Int) : Option[Move] = {
        val groups = groupMoves
        var row = groups.find(_.length == sz).getOrElse(return None)
        Some(Move(row.head.row, row.head.column+offset, number))
    }

    def findEquivalentMove(sz : Int, number : Int) : Option[Move] = {
        findEquivalentMove(sz, 0, number)
        /*
        val groups = groupMoves
        var row = groups.find(_.length == sz).getOrElse(return None)
        Some(Move(row.head.row, row.head.column, number))
        */
    }
    def nextCanonicalMove() : CanonicalMove = {
		nextMove match {
			case Move(0,0,0) => return CanonicalMove(0, 0, 0) 
			case _ => return canonicalMove(nextMove) 
          }
    }

    // Returns move in group size, offset, number of sticks to take
    def canonicalMove(m: Move) : CanonicalMove = {
        val r = rows(m.row)
        // get end of this group (via span)
        // get start of this group (via span)
        // offset it this start - offset
        //
        val (b4, aft) = r splitAt m.column
        val b4Size = b4.reverse.takeWhile(_ == false).length
        val aftSize = aft.takeWhile(_ == false).length
        val groupSize = b4Size + aftSize
        if (b4Size > 0) {
            // change group at the end to group at the start
            if (m.number == aftSize) {
                return CanonicalMove(groupSize, 0, m.number)
            } else if (b4Size > (aftSize-m.number)) { // tjj
                return CanonicalMove(groupSize, aftSize-m.number, m.number)
              } else {
                return CanonicalMove(groupSize, b4Size, m.number)
              }
        }
        CanonicalMove(groupSize, 0, m.number)
    }
	
	def this(m : Move, s: Sticks) = {
		this()
		rows = s.rows
	    val rowz = rows.zipWithIndex
		rows = rowz map (p => if (p._2 == m.row) applyMoveToList(m, p._1).getOrElse(throw new BadMove) else p._1)
	}
	
	def groupMoves() : List[List[Move]] = {
	    val rowz = rows zipWithIndex
	    var c : List[List[(Boolean, Move)]] = Nil
	    c = rowz.foldLeft(c) { (a, b) => Sticks.packMoves(Sticks.addMoves(b._1, b._2)) ::: a }
	    val x = c map { l => l.map { r => r._2 } }
	    //val x = for ( l <- c) for ( t <- l) yield(List(t._2))
	    //c map (j)
	    //for ( r <- c) yield(r)
	//		for (b <- bm) yield (b._1, (b._2.wins - b._2.losses))
	    x
	}
    /*
    // Need to fix CanWin to include check of 2 rows left, one that is size 1
	def endGame() : (EndGame, Move) = {
        val groups = groupMoves
        if (groups.tail != Nil) {
        	return (KeepGoing, Move(0,0,1))
        } 
        if (groups.head.tail != Nil) {
        	val m = groups.head.head
        	return (CanWin, Move(m.row, m.column, groups.head.length-1))
        }
        //if (groups.head.tail == Nilbbb)
        (Lost, groups.head.head)
	}
    */
	def endGame() : (EndGame, Move) = {
        val groups = groupMoves
        if (groups == Nil) {
           println("groups.head is Nil")
           print
        }
        if (groups.tail != Nil || groups.head.tail != Nil) {
        	return (KeepGoing, Move(0,0,1))
        } 
        //if (groups.head.tail == Nilbbb)
        (Lost, groups.head.head)
	}
	
	def applyMove (m : Move) : Sticks = {
		nextMove = m
		//val s = new Sticks(move)
		new Sticks(m, this)
	}
	
	def canonical() : String = {
		//var c : List[Int] = Nil
		var s = ""
		var c : List[Int] = Nil
		c = rows.foldLeft(c) { (a,b) => canonical(b) ::: a }
		c = c.sort((a, b) => a < b)
		c foreach (i => if (s.length > 0) s += "-" + i else s=""+i)
		s
	}
	def canonical(l : List[Boolean]) : List[Int] = {
		var nl : List[Int] = Nil
		var g=0
		l foreach ( i => if (i) {
			if (g>0) {
				nl = g :: nl 
				g = 0
			}
		} else {
			g += 1
		})
		if (g > 0) nl = g :: nl
		nl
	}
	def validMove(m: Move) : Boolean = {
	    val r = rows(m.row)
		val end = m.column + m.number - 1
		if (end > r.size-1) return false

		for (i <- m.column to end if r(i)) return false

        val groups = groupMoves
        // Last group
        if (groups.tail == Nil) {
            // Last group > 1
            if (groups.head.tail != Nil) {
                // Can't select em all
                if (m.number >= groups.head.length) return false
            }
        }

		return true;
	}
	
	def applyMoveToList(m: Move, l : List[Boolean]) : Option[List[Boolean]] = {
		val end = m.column + m.number - 1
		if (end > l.size-1) return None
		for (i <- m.column to end if l(i)) return None
		var nl : List[Boolean] = Nil
		
		if (end < l.size-1) nl = l.slice(end+1, l.size)
		for (i <- m.column to end) nl = true :: nl
		if (m.column > 0) nl = l.slice(0,m.column) ::: nl
		Some(nl)
	}

	override def toString() : String = {
        var s = ""
		for (row <- rows) {
			s += "\n"
			for (stick <- row) s += " " + stick
		}
        s
	}
	
	def print() {
		for (row <- rows) {
			println("")
			for (stick <- row) Console.print(" " + stick)
		}
     	println("")
	}
}
object Move {
	def next(m : Move) : Move = {
		m.row match {
			case 0 => 
				if (m.column == 0) {
					if (m.number == 0) Move (0, 0, 1) 
					else Move(1, 0, 1)
				} else throw new BadMove
			case 1 =>
				if (m.column + m.number < 3) Move (1, m.column+1, m.number)
				else Move(2, 0, m.number)
			case 2 =>
				if (m.column + m.number < 5) Move (2, m.column+1, m.number)
				else Move(3, 0, m.number)
			case 3 =>
				if (m.column + m.number < 7) Move (3, m.column+1, m.number)
				else m.number match {
					case 1 => Move(1, 0, 2)
					case 2 => Move(1, 0, 3)
					case 3 => Move(2, 0, 4)
					case 4 => Move(2, 0, 5)
					case 5 => Move(3, 0, 6)
					case 6 => Move(3, 0, 7)
					case 7 => throw new BadMove
				}
		}
	}
	import scala.collection.mutable.ListBuffer
	def allMoves(canonical: String) : List[Move] = {
        val a = canonical.split('-').toList
        val i = a.map(_.toInt)
        allMoves(i)
    }
	def allMoves(rowMax : List[Int]) : List[Move] = {
	  val mb = new ListBuffer[Move]
      for (row <- 0 to 3) {
        for (off <- 0 to rowMax(row)-1) {
           for (size <- 1 to rowMax(row)-off) {
	 	      mb += Move(row, off, size)
           }
        }
      }
      mb.toList
    }
	def allMoves() : List[Move] = {

      val rowMax = List(1,3,5,7)
      allMoves(rowMax)
		
        /*
	  var m = Move(0, 0, 0)
	  var done = false
	  val mb = new ListBuffer[Move]
	  while (!done) {
	 	  try {
	 		  m = m.next()
	 		  mb += m
	 	  } catch {
	 	 	  case bm: BadMove => done = true
	 	  }
	  }
	   return mb.toList
       */
	}
}

case class Move (val row: Int, val column : Int, val number : Int) extends Ordered[Move]
{
	def next() : Move = {
		Move.next(this)
	}
	def print() {
		println (row + " " + column + " " + number)
	}
	def compare(that: Move) = {
        (this.row*100 + this.column*10 + this.number) - (that.row*100 + that.column*10 + that.number)
	}
}

object CanonicalMove {
	import scala.collection.mutable.ListBuffer

    def allMoves() : List[CanonicalMove] = {

	  val mb = new ListBuffer[CanonicalMove]
      for (gs <- 1 to 7) {
        for (off <- 0 to gs/2) {
           for (size <- 1 to gs - off) {
             if ((gs-(off+size)) >= off)  
	 	        mb += CanonicalMove(gs, off, size)
           }
        }
      }
      mb.toList
	}
	def allMoves(canonical: String) : List[CanonicalMove] = {
        val a = canonical.split('-').toList
        val a2 = removeDuplicates(a)
        val i = a2.map(_.toInt)
        allMoves(i)
    }
	def allMoves(groups : List[Int]) : List[CanonicalMove] = {
	  val mb = new ListBuffer[CanonicalMove]
      groups foreach (gs => {
        for (off <- 0 to gs/2) {
           for (size <- 1 to gs - off) {
             if ((gs-(off+size)) >= off)  
	 	      mb += CanonicalMove(gs, off, size)
           }
        }
      })
      mb.toList
    }
    def removeDuplicates[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) xs
      else
      xs.head :: removeDuplicates(
      xs.tail filter (x => x != xs.head)
      )
    }
}

case class CanonicalMove (val groupSize: Int, val offset : Int, val number : Int) extends Ordered[CanonicalMove]
{
	def print() {
		println (groupSize + " " + offset + " " + number)
	}
	def compare(that: CanonicalMove) = {
        (this.groupSize*100 + this.offset*10 + this.number) - (that.groupSize*100 + that.offset*10 + that.number)
	}
}

import scala.collection.mutable.HashMap
import scala.collection.mutable.{HashSet => MHashSet}
import scala.collection.immutable.SortedMap 

case class MoveResults (var wins: Int, var losses: Int) extends (Ordered[MoveResults])
{ 
	def compare (that: MoveResults) = {
		(this.losses-this.wins) - (that.losses-that.wins)
		//(this.losses-that.losses)
        //if (this.wins == 0 && this.losses == 0) -1000 else (this.losses-that.losses)
	}
}

class BestMoves
{
	/*
	 * Indexed by canonical configuration (a string). Each string points to an (ordered?) set of (Move/percent)
	 * tuples. 
	 */
	
	val bestMoves = new HashMap[String, HashMap[CanonicalMove, MoveResults]] //{ override def default(key:String) = () }
	
	var p1Wins = 0
	var p2Wins = 0
	
	def toString(m : HashMap[CanonicalMove, MoveResults]) : String = {
		val s = SortedMap[CanonicalMove, MoveResults]() ++ m
		"" + s
	}
	override def toString() : String = {
		var y = ""
		bestMoves.foreach (x => y = (x._1 + toString(x._2)))
		y
	}
	def toString(canonical : String) : String = {
        if (bestMoves.contains(canonical)) {
             toString(bestMoves(canonical))
           } else {
           ""
         }
	}

	def addMoves(game : List[Sticks], p1: Boolean, won : Boolean) : Unit = {
        var weight = 1
		def addWinner(winners : List[Sticks]) : Unit = {
			//println("Tom addWinner " + winners.head.nextMove)
			//println("Tom whc " + winners.head.canonical)
			if (winners.head.nextMove == Move(0, 0, 0)) return
            val canonical = winners.head.canonical
			if (bestMoves.contains(canonical)) {
				val entry = bestMoves(canonical)
		        //if (!p1Won) entry(winners.head.nextMove).wins += 1
		        if (won) entry(winners.head.nextCanonicalMove).wins += 1
		        //entry(winners.head.nextMove).wins += 1
			} else {
				val entry = HashMap.empty[CanonicalMove, MoveResults]
				CanonicalMove.allMoves(canonical) foreach (x => entry.update(x, MoveResults(0,0)))
		        //if (!p1Won) entry(winners.head.nextMove).wins += 1
		        if (won) entry(winners.head.nextCanonicalMove).wins += 1
		        //if (won) entry(winners.head.nextMove).wins += 1
				bestMoves.update(canonical, entry)
			//println("Tom hm " + hm(Move(0,0,1)))
			}
			winners match {
				case _ :: tail => addLoser(tail)
				case _ => Unit
			}
		}
		
		def addLoser(losers : List[Sticks]) : Unit = {
			//println("Tom addLoser " + losers.head.nextMove)
			if (losers.head.nextMove == Move(0, 0, 0)) return
            val canonical = losers.head.canonical
			if (bestMoves.contains(canonical)) {
				val entry = bestMoves(canonical)
		        //if (p1Won) entry(losers.head.nextMove).losses += 1
		        if (!won) entry(losers.head.nextCanonicalMove).losses += (1 * weight)
                //if (!won && !p1) 
                //println("P2: " + losers.head.canonical() + ": " + losers.head.nextMove + ", " + entry(losers.head.nextMove))
		        //entry(losers.head.nextMove).losses += 1
			} else {
				val entry = HashMap.empty[CanonicalMove, MoveResults]
				CanonicalMove.allMoves(canonical) foreach (x => entry.update(x, MoveResults(0,0)))
		        if (!won) entry(losers.head.nextCanonicalMove).losses += (1 * weight)
                //if (!won && !p1) 
                //println("P2: " + losers.head.canonical() + ": " + losers.head.nextMove + ", " + entry(losers.head.nextMove))
		        //if (!p1Won) entry(losers.head.nextMove).losses += 1
		        //entry(losers.head.nextMove).losses += 1
				bestMoves.update(canonical, entry)
			}
            weight *= 1 // Experimenting...
			losers match {
				case _ :: tail => addWinner(tail)
				case _ => Unit
			}
		}
		
		//if (game.length % 2 == 0) {
		if (p1 && won || !p1 && !won) {
			addWinner(game)
		} else {
			addLoser(game)
		}
	}
	def possibleMoves(s : Sticks) : List[(CanonicalMove, Int)] = {
		if (bestMoves.contains(s.canonical())) {
			val bm = bestMoves(s.canonical()).toList sortBy(_._2)
			for (b <- bm) yield (b._1, (b._2.wins - b._2.losses))
		} else {
			for (a <- CanonicalMove.allMoves(s.canonical)) yield (a, 0)
			//Move.allMoves.zip(List(0))
		}
	}
	def bestMove(s : Sticks) : (Move, Int) = {
		val pm = possibleMoves(s)
		for (cm <- pm) {
            val em = s.findEquivalentMove(cm._1)
            em match {
              case Some(m) => if (s.validMove(m)) return (m, cm._2)
              case None =>
            }
          }
		throw new BadMove
	}

/*
	def randomMove(s : Sticks) : Move = {
		val am = Move.allMoves()
        val vm = am.filter(s.validMove(_))
        val rm = removeAt((new util.Random).nextInt(vm.length), vm)._2
        rm
	}
    */

	def moveResults(m : CanonicalMove, canonical: String) : MoveResults = {
        if (bestMoves.contains(canonical)) {
        	val entry = bestMoves(canonical)
        	if (entry contains m) {
        		entry(m)
        	} else {
        		MoveResults(0, 0)
        	}
        } else {
        	MoveResults(0, 0)
        }
	}
	
}
