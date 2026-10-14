package com.portfolio.my_portfolio_backend_ruben.service;

import com.portfolio.my_portfolio_backend_ruben.exception.ValidationException;
import com.portfolio.my_portfolio_backend_ruben.model.Skill;
import com.portfolio.my_portfolio_backend_ruben.repository.ISkillRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Usar mockito
public class SkillServiceImplTest {
    //Con interfaz
    @Mock
    private ISkillRepository skillRepository;

    @Mock
    private Validator validator;

    //Sin interfaz
    @InjectMocks
    private SkillServiceImpl skillService;

    @Test
    void testFindAllReturnsListOfSkills(){
        //Arrange
        List<Skill> mockSkills = Arrays.asList(new Skill(), new Skill());
        when(skillRepository.findAll()).thenReturn(mockSkills);

        //Act
        List<Skill> skills = skillService.findAll();

        //Assert
        assertNotNull(skills);
        assertEquals(2, skills.size());
        verify(skillRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdReturnsSkillWhenFound(){
        Long id = 1L;
        Skill skillMock = new Skill();
        when(skillRepository.findById(id)).thenReturn(Optional.of(skillMock));

        Optional<Skill> skillOptional = skillService.findById(id);

        assertTrue(skillOptional.isPresent());
        assertEquals(skillMock, skillOptional.get());
        verify(skillRepository, times(1)).findById(id);
    }

    @Test
    void testSaveSkillThrowsExceptionWhenInvalid(){

        Skill invalidSkill = new Skill();
        doAnswer(invocationOnMock -> {
            BindingResult result = invocationOnMock.getArgument(1);
            result.rejectValue("name", "NotBlanck",
                    "El nombre no puede estar vacío");
            return null;
        }).when(validator).validate(any(Skill.class), any(BindingResult.class));

        assertThrows(ValidationException.class, () -> skillService.save(invalidSkill),
                "Debe lanzarse un ValidationException si el objeto no es válido.");

        verify(skillRepository, never()).save(any(Skill.class));

    }

    @Test
    void testSaveSkillSavesValidSkill(){
        //Arrange
         Skill validSkill = new Skill(null, "Java", 90, "fab fa-java", 1L);
         when(skillRepository.save(any(Skill.class))).thenReturn(validSkill);
        doNothing().when(validator).validate(any(Skill.class), any(BindingResult.class));

        //Act
        Skill savedSkill = skillService.save(validSkill);

        //Assert
        assertNotNull(savedSkill);
        verify(skillRepository, times(1)).save(validSkill);
    }

}
