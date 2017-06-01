package demo

import groovy.transform.CompileStatic
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

import javax.servlet.http.HttpServletRequest

/**
 * A tenant resolver that resolves the tenant from the Subdomain
 *
 * @author Graeme Rocher
 * @since 6.0
 */
@CompileStatic
class HeaderTenantResolver implements TenantResolver {
    public static final String HEADER_NAME = "gorm.tenantId"

    @Override
    Serializable resolveTenantIdentifier() {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if(requestAttributes instanceof ServletWebRequest) {

            HttpServletRequest httpServletRequest = ((ServletWebRequest) requestAttributes).getRequest()
            String tenantId = httpServletRequest.getHeader(HEADER_NAME.toLowerCase())

            if ( tenantId ) {
                return tenantId
            } else {
                throw new TenantNotFoundException()
            }
        }
        throw new TenantNotFoundException("Tenant could not be resolved outside a web request")
    }
}