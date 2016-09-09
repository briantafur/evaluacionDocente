
package co.edu.eam.ingesoft.pa2.cliente.entidades;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiciosEducativosService", targetNamespace = "http://www.eam.edu.co", wsdlLocation = "http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl")
public class ServiciosEducativosService
    extends Service
{

    private final static URL SERVICIOSEDUCATIVOSSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICIOSEDUCATIVOSSERVICE_EXCEPTION;
    private final static QName SERVICIOSEDUCATIVOSSERVICE_QNAME = new QName("http://www.eam.edu.co", "ServiciosEducativosService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOSEDUCATIVOSSERVICE_WSDL_LOCATION = url;
        SERVICIOSEDUCATIVOSSERVICE_EXCEPTION = e;
    }

    public ServiciosEducativosService() {
        super(__getWsdlLocation(), SERVICIOSEDUCATIVOSSERVICE_QNAME);
    }

    public ServiciosEducativosService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOSEDUCATIVOSSERVICE_QNAME, features);
    }

    public ServiciosEducativosService(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOSEDUCATIVOSSERVICE_QNAME);
    }

    public ServiciosEducativosService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOSEDUCATIVOSSERVICE_QNAME, features);
    }

    public ServiciosEducativosService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiciosEducativosService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiciosAcademicos
     */
    @WebEndpoint(name = "serviciosAcademicos")
    public ServiciosAcademicos getServiciosAcademicos() {
        return super.getPort(new QName("http://www.eam.edu.co", "serviciosAcademicos"), ServiciosAcademicos.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiciosAcademicos
     */
    @WebEndpoint(name = "serviciosAcademicos")
    public ServiciosAcademicos getServiciosAcademicos(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.eam.edu.co", "serviciosAcademicos"), ServiciosAcademicos.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOSEDUCATIVOSSERVICE_EXCEPTION!= null) {
            throw SERVICIOSEDUCATIVOSSERVICE_EXCEPTION;
        }
        return SERVICIOSEDUCATIVOSSERVICE_WSDL_LOCATION;
    }

}
