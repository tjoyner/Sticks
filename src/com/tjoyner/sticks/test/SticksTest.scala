package com.tjoyner.sticks.test

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import com.tjoyner.sticks._
import EndGame._

class SticksTest extends AssertionsForJUnit {
	@Test def testStickMoves() {
		val s1=new Sticks()
		assertEquals("1-3-5-7", s1.canonical)
   	    val s2=s1.applyMove(Move(0,0,1))
		assertEquals(Move(0,0,1), s1.nextMove)
		assertEquals("3-5-7", s2.canonical)
		intercept[BadMove] {
			s2.applyMove(Move(0,0,1))
		}
		assertTrue(s1.validMove(Move(0,0,1)))
		assertFalse(s2.validMove(Move(0,0,1)))
		assertTrue(s2.validMove(Move(1,0,1)))
		assertTrue(s2.validMove(Move(1,0,1)))
		assertTrue(s2.validMove(Move(1,0,3)))
		assertFalse(s2.validMove(Move(1,0,4)))
		assertFalse(s2.validMove(Move(1,1,3)))
   	    val s3=s2.applyMove(Move(1,0,1))
		assertEquals("2-5-7", s3.canonical)
   	    val s4=s3.applyMove(Move(3,1,6))
		assertEquals(Move(3,1,6), s3.nextMove)
		assertEquals("1-2-5", s4.canonical)
		val game=List(s1, s2, s3, s4)
		/*
		BestMoves.p1BestMoves.addMoves(game, true, true)
		val m1 = BestMoves.moveResults(Move(0,0,1), "1-3-5-7")
		assertEquals(MoveResults(1,0), m1)
		val m2 = BestMoves.moveResults(Move(1,0,1), "3-5-7")
		assertEquals(MoveResults(0,1), m2)
		
		val m3 = BestMoves.possibleMoves(s3)
		println("Possible: " + m3)
		val m0 = for(a <-Move.allMoves) yield (a, 0)
		println("Allmoves zipped: "+ m0)
		*/
	}
	@Test def testEndGame() {
		val s1=new Sticks()
   	    val s2=s1.applyMove(Move(0,0,1))
   	    var eg = s2.endGame
		assertEquals(KeepGoing, eg._1)
   	    val s3=s2.applyMove(Move(1,0,3))
   	    eg = s3.endGame
		assertEquals(KeepGoing, eg._1)
   	    val s4=s3.applyMove(Move(2,0,5))
   	    eg = s4.endGame
		assertEquals(KeepGoing, eg._1)
   	    val s5=s4.applyMove(Move(3,0,6))
   	    eg = s5.endGame
		assertEquals((Lost, Move(3, 6, 1)), eg)
	}
	@Test def testLetsPlayP1Loses() {
       val r = List(
                 List(true), 
                 List(false, false, false), 
                 List(true, false, false, false, true),
                 List(true, true, true, true, true, true, true)
                 )
        var p1Moves = List(Move(1,0,1), Move(1,1,2))
        def moveP1(s: Sticks) : Sticks = {
            val nm = p1Moves.head
            p1Moves = p1Moves.tail
            s.applyMove(nm)
        }
        var p2Moves = List(Move(2,1,1), Move(2,3,1))
        def moveP2(s: Sticks) : Sticks = {
            val nm = p2Moves.head
            p2Moves = p2Moves.tail
            s.applyMove(nm)
        }
		val s=new Sticks(r)
        LetsPlay.p1 = moveP1
        LetsPlay.p2 = moveP2
        val game = LetsPlay.play(s)
		assertEquals((0,1), LetsPlay.results())
		val m1 = LetsPlay.p1BestMoves.moveResults(Move(1,0,1), "3-3")
		assertEquals(MoveResults(0,1), m1)
		val m2 = LetsPlay.p2BestMoves.moveResults(Move(2,1,1), "2-3")
		assertEquals(MoveResults(1,0), m2)
		val m3 = LetsPlay.p1BestMoves.moveResults(Move(1,1,2), "2-2")
		assertEquals(MoveResults(0,1), m3)
        //game.foreach (_.print)
		val m4 = LetsPlay.p2BestMoves.moveResults(Move(2,3,1), "2")
		assertEquals(MoveResults(1,0), m4)
	}
}
