package com.example.flingapp.View

class User {
    var name:String = ""
    var email:String = ""
    var password:String = ""

    constructor(name: String, email: String, password: String){
        this.name = name
        this.email = email
        this.password = password
    }

    constructor(email: String, password: String){
        this.email = email
        this.password = password
        this.name = ""
    }
}