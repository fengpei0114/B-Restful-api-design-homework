package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository = new GroupRepository();
    private final StudentService studentService = new StudentService();

    public List<Group> getGroupList() {
        return groupRepository.getGroupList();
    }

    public void updateGroup(Group group) {
        groupRepository.updateGroup(group);
    }

    public List<Group> randomlyAllocate() {
        List<Group> groupList = groupRepository.getGroupList();
        groupList.forEach(group -> group.setStudentList((new ArrayList<>())));
        List<Student> studentList = studentService.getStudentList(null);
        Collections.shuffle(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            groupList.get(i % groupList.size()).getStudentList().add(studentList.get(i));
        }
        for (Group group : groupList) {
            groupRepository.updateGroup(group);
        }
        return groupRepository.getGroupList();
    }

    public Group getGroupById(Integer id) {
        return groupRepository.getGroupById(id);
    }
}
