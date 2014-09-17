package grailsinthecloud.bookstore

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Author)
class AuthorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Saving valid author to the database"() {

	    given: "A valid Author"
	        def author = new Author(name: 'blabla')

	    when: "The Author is saved"
	        author.save()

	    then: "It saved successfully and can be found in the database"
	        author.errors.errorCount == 0
	        author.id != null
	        Author.get(author.id).name == author.name
	}

	def "Trying to save an Author with invalid name causes an error"() {

	    given: "An Author without name"
	        def author = new Author()

	    when: "The Author is validated"
	        author.validate()

	    then: "It is not saved and error information can be obtained"
	        author.hasErrors()
	        author.errors.errorCount != 0
	        author.id == null
	        author.errors['name'].code == 'nullable'
	}
    
}