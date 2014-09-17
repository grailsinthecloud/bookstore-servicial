package grailsinthecloud.bookstore

import grailsinthecloud.bookstore.enums.AdminLevel

class AdminUser extends User {

	AdminLevel level

    static constraints = {
    	importFrom User, include: ['login','password']
    }

}