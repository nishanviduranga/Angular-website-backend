package unittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import rc.springbootmongodbdemo.repository.StudentsRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class Studenttest {

        private MockMvc mockMvc;

        @MockBean
        StudentsRepository studentRepository;

        @Autowired
        Studenttest(MockMvc mockMvc) {
            this.mockMvc = mockMvc;
        }

        @Test
        void whengetStudentById() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/Student/saveStudent",1)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("nishan"));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(StatusCode.S200.toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(new Employee()));
        }

    }

