package demo

import grails.compiler.GrailsCompileStatic
import grails.gorm.MultiTenant

@GrailsCompileStatic
class Person implements MultiTenant<Person> {
    String name
    String owner

    static mapping = {
        tenantId name:'owner'
    }
}