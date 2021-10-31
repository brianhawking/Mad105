package com.example.rowreduction

import java.io.Serializable

class Rational(var num: Long, var den: Long)  {
    override fun toString() : String {
        return if (den == 1L) {
            "$num"
        } else {
            "$num/$den"
        }
    }

//    operator fun Rational.plus(other: Rational): Rational {
//        return Rational((num * other.den)+(den * other.num), den * other.den)
//    }

    operator fun plus(other: Rational) : Rational {
        return Rational((num * other.den)+(den * other.num), den * other.den)
    }

    operator fun minus(other: Rational) : Rational {
        return Rational((num * other.den)-(den * other.num), den * other.den)
    }

    operator fun times(other: Rational) : Rational {
        return Rational(num * other.num, den * other.den)
    }

    operator fun div(other: Rational) :Rational {
        return Rational(num * other.den, den * other.num)
    }
}