package com.example.covidphonetracker

class UnionFind (n : Int ) {
    val roots = IntArray(n){idx -> idx}
    private val ranks = IntArray(n){ 1 }

    fun find(i: Int?): Int{
        if(roots[i!!] != i){
            roots[i!!] = find(roots[i])
        }

        return roots[i]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (ranks[rootX] > ranks[rootY]) {
            roots[rootY] = rootX
            ++ranks[rootX]
        } else {
            roots[rootX] = rootY
            ++ranks[rootY]
        }
    }




}