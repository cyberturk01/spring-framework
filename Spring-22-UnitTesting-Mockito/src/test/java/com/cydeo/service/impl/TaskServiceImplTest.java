package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.Role;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @MockBean
    private ProjectMapper projectMapper;

    @MockBean
    private UserRepository userRepository;

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskServiceImpl;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, -5L})
    void findById_test(long id) {

        // Given
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());

        // When
        taskServiceImpl.findById(id);

        // Then
        verify(taskRepository).findById(id);
        verify(taskRepository).findById(anyLong());

        verify(taskMapper).convertToDTO(any(Task.class));
        verify(taskMapper).convertToDTO(task);

//        verify(taskRepository, never()).findById(-5L);

    }

}
