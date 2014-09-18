package grailsinthecloud.bookstore

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AuthorService)
class AuthorServiceSpec extends Specification {

	def users

	def setupSpec() {

	}
	
    def setup() {
    	users = [ User.build(name: 'Carlos', age:10),User.build(age:15),User.build(age:3),User.build(age:8) ]
    }

    def cleanup() {
    }

    void "test obtener usuarios por age"() {

    	given:
    		def age = 5

		when:
			def results = service.obtenerUsuariosPorCondicion(age)

		then:
			results != null
			results.size() == 3
			results.find { it.name == 'Carlos' }.age == 10

    }

    void "test obtener usuarios por age"() {

    	given:
    		def age = 50

		when:
			def results = service.obtenerUsuariosPorCondicion(age)

		then:
			results != null
			results.size() == 0

    }

}