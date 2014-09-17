package grailsinthecloud.bookstore

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(User)
class UserSpec extends Specification {

	def inputData

    def setup() {

    	inputData = [
			name: 'user1', 
			login:'myusername', 
			password: 'mypassword',
			email: 'myemail@gmail.com', 
			birthDate: new Date() - 1, 
			age: 20,
			cardNumber: '4444444444444448', 
			cardType: 'VISA', 
			hasFacebookLogin: true,
			facebookId: 123123123123, 
			score: 8
		]

    }

    def cleanup() {
    }

    def "Saving valid user to the database"() {

	    given: "A valid User"
	        def user = new User(inputData)

	    when: "The User is saved"
	        user.save()

	    then: "It saved successfully and can be found in the database"
	        user.errors.errorCount == 0
	        user.id != null
	        User.get(user.id).name == user.name
	}

	//testing fields ony by one

	def "Trying to save an User with no name causes an error"() {

	    given: "An User with no name"
	    	inputData.remove('name')
	        def user = new User(inputData)

	    when: "The User is validated"
	        user.validate()

	    then: "Error information can be obtained"
	        user.hasErrors()
	        user.errors.errorCount > 0
	        user.errors['name'].code == 'nullable'
	        user.errors['name'].rejectedValue == null
	}

	//super testing

	def "Trying to save an User with invalid fields causes an error"(field, value, code) {

	    given: "An User with invalid fields"
	        def user = new User("$field": value)

	    when: "The User is validated"
	        user.validate()

	    then: "Error information can be obtained"
	     	if (!code) {
			    !user.errors[field]
			} else {
			    user.errors[field]
			    user.errors[field].code == code
			    user.errors[field].rejectedValue == value
			}

        where:
        	field 			| value 				| code
        	'name' 			| 'Mathias'				| null
        	'name' 			| null					| 'nullable'
        	'login'			| 'myvalidname' 		| null
        	'login'			| null 					| 'nullable'
        	'login'			| '123123' 				| 'matches.invalid'
        	'login'			| 'a' 					| 'size.toosmall'
        	'login'			| 'abcdefghijklmopq' 	| 'size.toobig'
        	'password'		| 'myvalidpasswor' 		| null
        	'password'		| null 					| 'nullable'
        	'password'		| 'a' 					| 'size.toosmall'
        	'password'		| 'abcdefghijklmopq' 	| 'size.toobig'
        	'email'			| 'fine@gmail.com' 		| null
        	'email'			| 'notfine' 			| 'email.invalid'
        	'birthDate'		| new Date() - 2		| null
        	'birthDate'		| new Date() + 2		| 'max.exceeded'
        	'age'			| 20					| null
        	'age'			| 2						| 'range.toosmall'
        	'age'			| 200					| 'range.toobig'
        	'cardNumber'	| '4444444444444448' 	| null
        	'cardNumber'	| '2312312' 			| 'creditCard.invalid'
        	'cardType'		| 'VISA' 				| null
        	'cardType'		| 'VISTA' 				| 'not.inList'

	}

}