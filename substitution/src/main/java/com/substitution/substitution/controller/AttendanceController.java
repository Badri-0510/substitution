package com.substitution.substitution.controller;

import com.substitution.substitution.model.Attendance;
import com.substitution.substitution.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/teachersatt")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/update")
    public Attendance updateAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveOrUpdateAttendance(attendance);
    }

    @PostMapping("/substitution")
    public String handleSubstitution(@RequestParam("day") String day) {
        System.out.println("Day received: " + day);  // Log to verify
        attendanceService.assignSubstitutes(day);
        return "Substitution completed successfully.";
    }}