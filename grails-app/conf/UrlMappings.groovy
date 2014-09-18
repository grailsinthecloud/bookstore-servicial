class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/books"(controller:"book") {
			action = [GET:"index", PUT:"update", DELETE:"delete", POST:"save"]
	   	}

        "/"(view:"/index")
        "500"(view:'/error')
	}
	
}