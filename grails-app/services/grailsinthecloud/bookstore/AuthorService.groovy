package grailsinthecloud.bookstore

import grails.transaction.Transactional

@Transactional
class AuthorService {

	static scope = 'singleton'

    Author obtenerAuthor(long id) {

    	def a = Author.get(id)

    	return a

    }

    def obtenerUsuariosPorCondicion(ageGreaterThan = null, nameLike = null) {

    	def list = User.withCriteria {
    		or {
	    		gt('age', ageGreaterThan)
	    		ilike('name', nameLike)
	    	}
    	}

    	println 'lista: ' + list

    	return list

    }

}