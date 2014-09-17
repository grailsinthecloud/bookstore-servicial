package grailsinthecloud.bookstore.enums

enum AdminLevel {

	HYPER(1),
	SUPER(2),
	ULTRA(3)

	final int id
	
	private AdminLevel(int id) {
		this.id = id
	}

}