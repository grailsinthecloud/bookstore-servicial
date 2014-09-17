package grailsinthecloud.bookstore

class User {

	String name
	String login
	String password
	String email
	Date birthDate
	Integer age
	String cardNumber
	String cardType
	Boolean hasFacebookLogin
	Long facebookId
	String score

	static hasMany = [ top10Books : Book, reviews: Review ]

    static constraints = {
    	name blank: true
    	login size: 5..15, blank: false, unique: true, matches: "[a-zA-Z]+"
        password size: 5..15, blank: false
        email email: true, blank: false
        birthDate max: new Date()
        age range: 18..100
    	cardNumber creditCard: true, nullable: true
    	cardType nullable: true, inList: ['VISA', 'Master Card', 'Diners Club']
    	top10Books maxSize: 10
    	hasFacebookLogin validator: { val, obj -> !val || (val && obj.facebookId != null) }
    }

    static mapping = {
    	top10Books lazy: false
    	cardNumber column:'credit_card_number'
    }

    static transients = ['score']

}