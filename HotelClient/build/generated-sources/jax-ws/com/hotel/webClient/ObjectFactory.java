
package com.hotel.webClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hotel.webClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddNewCustomer_QNAME = new QName("http://webService.hotel.com/", "AddNewCustomer");
    private final static QName _AddNewCustomerResponse_QNAME = new QName("http://webService.hotel.com/", "AddNewCustomerResponse");
    private final static QName _GetHotelRoomsAvailabilityResponse_QNAME = new QName("http://webService.hotel.com/", "GetHotelRoomsAvailabilityResponse");
    private final static QName _GetRoomsOrders_QNAME = new QName("http://webService.hotel.com/", "getRoomsOrders");
    private final static QName _CustomerLogin_QNAME = new QName("http://webService.hotel.com/", "CustomerLogin");
    private final static QName _GetHotelRoomsAvailability_QNAME = new QName("http://webService.hotel.com/", "GetHotelRoomsAvailability");
    private final static QName _GetEmployees_QNAME = new QName("http://webService.hotel.com/", "GetEmployees");
    private final static QName _GetAllHotels_QNAME = new QName("http://webService.hotel.com/", "GetAllHotels");
    private final static QName _AddHotel_QNAME = new QName("http://webService.hotel.com/", "AddHotel");
    private final static QName _AddHotelResponse_QNAME = new QName("http://webService.hotel.com/", "AddHotelResponse");
    private final static QName _GetHotelDetailsResponse_QNAME = new QName("http://webService.hotel.com/", "GetHotelDetailsResponse");
    private final static QName _GetAllHotelsResponse_QNAME = new QName("http://webService.hotel.com/", "GetAllHotelsResponse");
    private final static QName _GetEmployeeCategoryWithId_QNAME = new QName("http://webService.hotel.com/", "GetEmployeeCategoryWithId");
    private final static QName _CustomerLoginResponse_QNAME = new QName("http://webService.hotel.com/", "CustomerLoginResponse");
    private final static QName _Login_QNAME = new QName("http://webService.hotel.com/", "Login");
    private final static QName _BooksRooms_QNAME = new QName("http://webService.hotel.com/", "BooksRooms");
    private final static QName _GetEmployeesResponse_QNAME = new QName("http://webService.hotel.com/", "GetEmployeesResponse");
    private final static QName _GetHotelsWithIdResponse_QNAME = new QName("http://webService.hotel.com/", "GetHotelsWithIdResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://webService.hotel.com/", "LoginResponse");
    private final static QName _AddEmployeeResponse_QNAME = new QName("http://webService.hotel.com/", "AddEmployeeResponse");
    private final static QName _BooksRoomsResponse_QNAME = new QName("http://webService.hotel.com/", "BooksRoomsResponse");
    private final static QName _GetRoomsOrdersResponse_QNAME = new QName("http://webService.hotel.com/", "getRoomsOrdersResponse");
    private final static QName _AddEmployee_QNAME = new QName("http://webService.hotel.com/", "AddEmployee");
    private final static QName _GetHotelDetails_QNAME = new QName("http://webService.hotel.com/", "GetHotelDetails");
    private final static QName _GetHotelsWithId_QNAME = new QName("http://webService.hotel.com/", "GetHotelsWithId");
    private final static QName _GetEmployeeCategoryWithIdResponse_QNAME = new QName("http://webService.hotel.com/", "GetEmployeeCategoryWithIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hotel.webClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerLogin }
     * 
     */
    public CustomerLogin createCustomerLogin() {
        return new CustomerLogin();
    }

    /**
     * Create an instance of {@link GetHotelRoomsAvailability }
     * 
     */
    public GetHotelRoomsAvailability createGetHotelRoomsAvailability() {
        return new GetHotelRoomsAvailability();
    }

    /**
     * Create an instance of {@link AddNewCustomerResponse }
     * 
     */
    public AddNewCustomerResponse createAddNewCustomerResponse() {
        return new AddNewCustomerResponse();
    }

    /**
     * Create an instance of {@link GetHotelRoomsAvailabilityResponse }
     * 
     */
    public GetHotelRoomsAvailabilityResponse createGetHotelRoomsAvailabilityResponse() {
        return new GetHotelRoomsAvailabilityResponse();
    }

    /**
     * Create an instance of {@link GetRoomsOrders }
     * 
     */
    public GetRoomsOrders createGetRoomsOrders() {
        return new GetRoomsOrders();
    }

    /**
     * Create an instance of {@link AddNewCustomer }
     * 
     */
    public AddNewCustomer createAddNewCustomer() {
        return new AddNewCustomer();
    }

    /**
     * Create an instance of {@link GetHotelDetailsResponse }
     * 
     */
    public GetHotelDetailsResponse createGetHotelDetailsResponse() {
        return new GetHotelDetailsResponse();
    }

    /**
     * Create an instance of {@link AddHotel }
     * 
     */
    public AddHotel createAddHotel() {
        return new AddHotel();
    }

    /**
     * Create an instance of {@link AddHotelResponse }
     * 
     */
    public AddHotelResponse createAddHotelResponse() {
        return new AddHotelResponse();
    }

    /**
     * Create an instance of {@link GetAllHotels }
     * 
     */
    public GetAllHotels createGetAllHotels() {
        return new GetAllHotels();
    }

    /**
     * Create an instance of {@link GetEmployees }
     * 
     */
    public GetEmployees createGetEmployees() {
        return new GetEmployees();
    }

    /**
     * Create an instance of {@link BooksRooms }
     * 
     */
    public BooksRooms createBooksRooms() {
        return new BooksRooms();
    }

    /**
     * Create an instance of {@link GetEmployeesResponse }
     * 
     */
    public GetEmployeesResponse createGetEmployeesResponse() {
        return new GetEmployeesResponse();
    }

    /**
     * Create an instance of {@link GetHotelsWithIdResponse }
     * 
     */
    public GetHotelsWithIdResponse createGetHotelsWithIdResponse() {
        return new GetHotelsWithIdResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link CustomerLoginResponse }
     * 
     */
    public CustomerLoginResponse createCustomerLoginResponse() {
        return new CustomerLoginResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetAllHotelsResponse }
     * 
     */
    public GetAllHotelsResponse createGetAllHotelsResponse() {
        return new GetAllHotelsResponse();
    }

    /**
     * Create an instance of {@link GetEmployeeCategoryWithId }
     * 
     */
    public GetEmployeeCategoryWithId createGetEmployeeCategoryWithId() {
        return new GetEmployeeCategoryWithId();
    }

    /**
     * Create an instance of {@link GetEmployeeCategoryWithIdResponse }
     * 
     */
    public GetEmployeeCategoryWithIdResponse createGetEmployeeCategoryWithIdResponse() {
        return new GetEmployeeCategoryWithIdResponse();
    }

    /**
     * Create an instance of {@link AddEmployee }
     * 
     */
    public AddEmployee createAddEmployee() {
        return new AddEmployee();
    }

    /**
     * Create an instance of {@link GetHotelDetails }
     * 
     */
    public GetHotelDetails createGetHotelDetails() {
        return new GetHotelDetails();
    }

    /**
     * Create an instance of {@link GetHotelsWithId }
     * 
     */
    public GetHotelsWithId createGetHotelsWithId() {
        return new GetHotelsWithId();
    }

    /**
     * Create an instance of {@link GetRoomsOrdersResponse }
     * 
     */
    public GetRoomsOrdersResponse createGetRoomsOrdersResponse() {
        return new GetRoomsOrdersResponse();
    }

    /**
     * Create an instance of {@link BooksRoomsResponse }
     * 
     */
    public BooksRoomsResponse createBooksRoomsResponse() {
        return new BooksRoomsResponse();
    }

    /**
     * Create an instance of {@link AddEmployeeResponse }
     * 
     */
    public AddEmployeeResponse createAddEmployeeResponse() {
        return new AddEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "AddNewCustomer")
    public JAXBElement<AddNewCustomer> createAddNewCustomer(AddNewCustomer value) {
        return new JAXBElement<AddNewCustomer>(_AddNewCustomer_QNAME, AddNewCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "AddNewCustomerResponse")
    public JAXBElement<AddNewCustomerResponse> createAddNewCustomerResponse(AddNewCustomerResponse value) {
        return new JAXBElement<AddNewCustomerResponse>(_AddNewCustomerResponse_QNAME, AddNewCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelRoomsAvailabilityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetHotelRoomsAvailabilityResponse")
    public JAXBElement<GetHotelRoomsAvailabilityResponse> createGetHotelRoomsAvailabilityResponse(GetHotelRoomsAvailabilityResponse value) {
        return new JAXBElement<GetHotelRoomsAvailabilityResponse>(_GetHotelRoomsAvailabilityResponse_QNAME, GetHotelRoomsAvailabilityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoomsOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "getRoomsOrders")
    public JAXBElement<GetRoomsOrders> createGetRoomsOrders(GetRoomsOrders value) {
        return new JAXBElement<GetRoomsOrders>(_GetRoomsOrders_QNAME, GetRoomsOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "CustomerLogin")
    public JAXBElement<CustomerLogin> createCustomerLogin(CustomerLogin value) {
        return new JAXBElement<CustomerLogin>(_CustomerLogin_QNAME, CustomerLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelRoomsAvailability }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetHotelRoomsAvailability")
    public JAXBElement<GetHotelRoomsAvailability> createGetHotelRoomsAvailability(GetHotelRoomsAvailability value) {
        return new JAXBElement<GetHotelRoomsAvailability>(_GetHotelRoomsAvailability_QNAME, GetHotelRoomsAvailability.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetEmployees")
    public JAXBElement<GetEmployees> createGetEmployees(GetEmployees value) {
        return new JAXBElement<GetEmployees>(_GetEmployees_QNAME, GetEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllHotels }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetAllHotels")
    public JAXBElement<GetAllHotels> createGetAllHotels(GetAllHotels value) {
        return new JAXBElement<GetAllHotels>(_GetAllHotels_QNAME, GetAllHotels.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "AddHotel")
    public JAXBElement<AddHotel> createAddHotel(AddHotel value) {
        return new JAXBElement<AddHotel>(_AddHotel_QNAME, AddHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "AddHotelResponse")
    public JAXBElement<AddHotelResponse> createAddHotelResponse(AddHotelResponse value) {
        return new JAXBElement<AddHotelResponse>(_AddHotelResponse_QNAME, AddHotelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetHotelDetailsResponse")
    public JAXBElement<GetHotelDetailsResponse> createGetHotelDetailsResponse(GetHotelDetailsResponse value) {
        return new JAXBElement<GetHotelDetailsResponse>(_GetHotelDetailsResponse_QNAME, GetHotelDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllHotelsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetAllHotelsResponse")
    public JAXBElement<GetAllHotelsResponse> createGetAllHotelsResponse(GetAllHotelsResponse value) {
        return new JAXBElement<GetAllHotelsResponse>(_GetAllHotelsResponse_QNAME, GetAllHotelsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeCategoryWithId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetEmployeeCategoryWithId")
    public JAXBElement<GetEmployeeCategoryWithId> createGetEmployeeCategoryWithId(GetEmployeeCategoryWithId value) {
        return new JAXBElement<GetEmployeeCategoryWithId>(_GetEmployeeCategoryWithId_QNAME, GetEmployeeCategoryWithId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "CustomerLoginResponse")
    public JAXBElement<CustomerLoginResponse> createCustomerLoginResponse(CustomerLoginResponse value) {
        return new JAXBElement<CustomerLoginResponse>(_CustomerLoginResponse_QNAME, CustomerLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "Login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooksRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "BooksRooms")
    public JAXBElement<BooksRooms> createBooksRooms(BooksRooms value) {
        return new JAXBElement<BooksRooms>(_BooksRooms_QNAME, BooksRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetEmployeesResponse")
    public JAXBElement<GetEmployeesResponse> createGetEmployeesResponse(GetEmployeesResponse value) {
        return new JAXBElement<GetEmployeesResponse>(_GetEmployeesResponse_QNAME, GetEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelsWithIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetHotelsWithIdResponse")
    public JAXBElement<GetHotelsWithIdResponse> createGetHotelsWithIdResponse(GetHotelsWithIdResponse value) {
        return new JAXBElement<GetHotelsWithIdResponse>(_GetHotelsWithIdResponse_QNAME, GetHotelsWithIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "LoginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "AddEmployeeResponse")
    public JAXBElement<AddEmployeeResponse> createAddEmployeeResponse(AddEmployeeResponse value) {
        return new JAXBElement<AddEmployeeResponse>(_AddEmployeeResponse_QNAME, AddEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooksRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "BooksRoomsResponse")
    public JAXBElement<BooksRoomsResponse> createBooksRoomsResponse(BooksRoomsResponse value) {
        return new JAXBElement<BooksRoomsResponse>(_BooksRoomsResponse_QNAME, BooksRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoomsOrdersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "getRoomsOrdersResponse")
    public JAXBElement<GetRoomsOrdersResponse> createGetRoomsOrdersResponse(GetRoomsOrdersResponse value) {
        return new JAXBElement<GetRoomsOrdersResponse>(_GetRoomsOrdersResponse_QNAME, GetRoomsOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "AddEmployee")
    public JAXBElement<AddEmployee> createAddEmployee(AddEmployee value) {
        return new JAXBElement<AddEmployee>(_AddEmployee_QNAME, AddEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetHotelDetails")
    public JAXBElement<GetHotelDetails> createGetHotelDetails(GetHotelDetails value) {
        return new JAXBElement<GetHotelDetails>(_GetHotelDetails_QNAME, GetHotelDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelsWithId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetHotelsWithId")
    public JAXBElement<GetHotelsWithId> createGetHotelsWithId(GetHotelsWithId value) {
        return new JAXBElement<GetHotelsWithId>(_GetHotelsWithId_QNAME, GetHotelsWithId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeCategoryWithIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.hotel.com/", name = "GetEmployeeCategoryWithIdResponse")
    public JAXBElement<GetEmployeeCategoryWithIdResponse> createGetEmployeeCategoryWithIdResponse(GetEmployeeCategoryWithIdResponse value) {
        return new JAXBElement<GetEmployeeCategoryWithIdResponse>(_GetEmployeeCategoryWithIdResponse_QNAME, GetEmployeeCategoryWithIdResponse.class, null, value);
    }

}
