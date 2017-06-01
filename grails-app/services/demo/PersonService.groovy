package demo

import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service
import groovy.transform.CompileStatic

@CurrentTenant
@Service(Person)
@CompileStatic
abstract class PersonService {

    abstract List<Person> findAll()

    abstract Person save(String name)

    abstract void delete(Serializable id)
}