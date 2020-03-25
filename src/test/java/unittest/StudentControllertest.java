package unittest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import rc.springbootmongodbdemo.repository.StudentsRepository;
import rc.springbootmongodbdemo.service.StudentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllertest {


        @MockBean
        private StudentsRepository studentsRepository;

        @MockBean
        private StudentService studentService;

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        StudentControllertest(MockMvc mockMvc) {
            this.mockMvc = mockMvc;
        }


        @Test
        void whenGetAllStudents() throws Exception
        {
            mockMvc.perform( get("/Student/getAllStudent")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());

        }


//
//       @Test
//       void whendeleteStudent() throws Exception
//       {
//        mockMvc.perform( MockMvcRequestBuilders
//                .delete("/Student/delete/{id}",1)
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());
//
//       }
//
//
//       @Test
//       void whenupdateStudent() throws Exception {
//           mockMvc.perform(MockMvcRequestBuilders
//                   .put("/Student/updateStudent/{id}")
//                   .accept(MediaType.APPLICATION_JSON))
//                   .andDo(print())
//                   .andExpect(status().isOk())
//                   .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());
//       }
//
//
//
//        @Test
//        public void whengetStudent() throws Exception
//        {
//
//        mockMvc.perform(get("/Student/studentID/{id}", 1)
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());
//
//
//        }
//
//        @Test
//        public void whensaveStudent() throws Exception {
//
//            mockMvc.perform(MockMvcRequestBuilders
//                    .post("/Student/saveStudent", 1)
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());
//
//
//        }
    }

