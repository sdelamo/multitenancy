package demo

import groovy.transform.CompileStatic

@CompileStatic
class PersonController {
    def allowedMethods = [index: 'GET', save: 'POST', delete: 'DELETE']
    static responseFormats = ['json']

    PersonService personService

    def index() {
        [persons: personService.findAll()]
    }

    def save(String name) {
        def person = personService.save(name)

        [person: person]
    }

    def delete(Long id) {
        personService.delete(id)
        []
    }
}