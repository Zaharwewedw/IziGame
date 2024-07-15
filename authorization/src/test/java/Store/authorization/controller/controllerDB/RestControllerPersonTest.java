package Store.authorization.controller.controllerDB;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import Store.authorization.model.Person;
import Store.authorization.service.db.PersonService;
import Store.authorization.service.kafka.KafkaProducerCatalog;
import Store.authorization.util.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class RestControllerPersonTest {

    @Mock
    private PersonService personService;

    @Mock
    private UserValidation userValidator;

    @Mock
    private KafkaProducerCatalog kafkaProducerCatalog;

    @InjectMocks
    private RestControllerPerson restControllerPerson;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(restControllerPerson).build();
    }

    @Test
    void getLastPersonTest() throws Exception {
        Long id = 1L;
        when(personService.getPersonFromDB(id)).thenReturn(Person.builder().name("jhon").build());

        mockMvc.perform(get("/api/person/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("jhon"));

        verify(personService, times(1)).getPersonFromDB(id);
    }

    @Test
    void getAllPersonTest() {
    }

    @Test
    void savePersonFromDB() {
    }

    @Test
    void updatePersonInDB() {
    }

    @Test
    void deletePersonFromDB() {
    }
}