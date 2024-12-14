package com.substitution.substitution.service;
import com.substitution.substitution.model.Attendance;
import com.substitution.substitution.model.Teacher;
import com.substitution.substitution.model.Timetable;
import com.substitution.substitution.model.Substitution;
import com.substitution.substitution.repository.AttendanceRepository;
import com.substitution.substitution.repository.TimetableRepository;
import com.substitution.substitution.repository.TeacherRepository;
import com.substitution.substitution.repository.SubstitutionRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.lang.reflect.Method;
import java.util.stream.Collectors;

import com.substitution.substitution.projection.TeacherIdProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AttendanceService {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);
    private final AttendanceRepository attendanceRepository;
    private final TimetableRepository timetableRepository;
    private final TeacherRepository teacherRepository;
    private final SubstitutionRepository substitutionRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, TimetableRepository timetableRepository, TeacherRepository teacherRepository,SubstitutionRepository substitutionRepository) {
        this.attendanceRepository = attendanceRepository;
        this.timetableRepository = timetableRepository;  // Ensure this is injected
        this.teacherRepository = teacherRepository;
        this.substitutionRepository=substitutionRepository;
    }
    public Attendance saveOrUpdateAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
    public List<Integer> getAbsentTeachersByDay(String day) {

        Attendance at=new Attendance();

        String day1=day;
        // Fetch the teacher ids for a specific day using the projection
        List<Integer> teacherIdList = attendanceRepository.findTeacherIdsByDay(day1.trim());

        logger.info("Hi"+ day1);

        logger.info("Absent Teacher IDs for day {}: {}", day1, teacherIdList);
        return teacherIdList;
    }
    public void assignSubstitutes(String day) {
        List<Integer> absentTeacherIds = getAbsentTeachersByDay(day);

        for (int teacherId : absentTeacherIds) {
            Timetable timetable = timetableRepository.findByTeacherIdAndDaysOfWeek(teacherId,day.trim());
            logger.info(timetable.getDays_of_week());
            if (timetable != null) {
                if (timetable.getP1() != null) {
                    assignSubstituteForPeriod(timetable, day, "p1",absentTeacherIds);
                }
                if (timetable.getP2() != null) {
                    assignSubstituteForPeriod(timetable, day, "p2",absentTeacherIds);
                }
                if (timetable.getP3() != null) {
                    assignSubstituteForPeriod(timetable, day, "p3",absentTeacherIds);
                }
                if (timetable.getP4() != null) {
                    assignSubstituteForPeriod(timetable, day, "p4",absentTeacherIds);
                }
                if (timetable.getP5() != null) {
                    assignSubstituteForPeriod(timetable, day, "p5",absentTeacherIds);
                }
            }
        }


    }

    private void assignSubstituteForPeriod(Timetable timetable, String day, String period,List<Integer> absentTeacherIds) {
        List<Teacher> availableTeachers;
        List<Integer> teacherIds;
        String periodValue = getPeriodValue(timetable, period);
        switch (period) {

            case "p1":
                // Fetch the teacher IDs for the given day and where p1 is null
         teacherIds = timetableRepository.findTeacherIdsByDayAndP1IsNull(day.trim(),absentTeacherIds);
                logger.info("Available teachers for p1 on day {}: {}", day, teacherIds);
// Fetch the teacher details using the teacher IDs
             availableTeachers = teacherRepository.findTeachersByIds(teacherIds);
                logger.info("Available teachers for p1 on day {}: {}", day, availableTeachers);
                break;
            case "p2":
              teacherIds = timetableRepository.findTeacherIdsByDayAndP2IsNull(day.trim(),absentTeacherIds);

// Fetch the teacher details using the teacher IDs
                availableTeachers = teacherRepository.findTeachersByIds(teacherIds);
                logger.info("Available teachers for p1 on day {}: {}", day, availableTeachers);
                break;
            case "p3":
               teacherIds = timetableRepository.findTeacherIdsByDayAndP3IsNull(day.trim(),absentTeacherIds);

// Fetch the teacher details using the teacher IDs
                availableTeachers = teacherRepository.findTeachersByIds(teacherIds);
                logger.info("Available teachers for p1 on day {}: {}", day, availableTeachers);
                break;
            case "p4":
              teacherIds = timetableRepository.findTeacherIdsByDayAndP4IsNull(day.trim(),absentTeacherIds);

// Fetch the teacher details using the teacher IDs
                availableTeachers = teacherRepository.findTeachersByIds(teacherIds);
                logger.info("Available teachers for p1 on day {}: {}", day, availableTeachers);
                break;
            case "p5":
             teacherIds = timetableRepository.findTeacherIdsByDayAndP5IsNull(day.trim(),absentTeacherIds);

// Fetch the teacher details using the teacher IDs
                availableTeachers = teacherRepository.findTeachersByIds(teacherIds);
                logger.info("Available teachers for p1 on day {}: {}", day, availableTeachers);
                break;
            default:
                throw new IllegalArgumentException("Invalid period: " + period);
        }

        if (availableTeachers.isEmpty()) {
            logger.info("No substitute available for {} on {}", period, day);
        } else {
            Teacher substitute = selectTeacherWithFewestSubstitutions(availableTeachers);
            substitute.setTotal_sub_attended(substitute.getTotal_sub_attended() + 1);
            teacherRepository.save(substitute);
            logger.info("Assigned substitute for {}: {}", period, substitute.getName());
            saveSubstitutionRecord(timetable.getTeacher_id(), substitute.getTeacher_id(), period, day, periodValue);
            // Perform database update for substitution assignment here
        }
    }
    private void saveSubstitutionRecord(int absentTeacherId, int substituteTeacherId, String period, String day,String classId) {
        Substitution substitutionRecord = new Substitution();
        substitutionRecord.setAbsent_t_id(absentTeacherId);
        substitutionRecord.setSubs_t_id(substituteTeacherId);
        substitutionRecord.setPrd_number(period);
        substitutionRecord.setDate(day);
        substitutionRecord.setClass_id(Integer.parseInt(classId));
        // You may need to add other fields such as `class_id` if available

        substitutionRepository.save(substitutionRecord);  // Assuming substitutionRecordRepository is injected
    }


    private Teacher selectTeacherWithFewestSubstitutions(List<Teacher> teachers) {
        return teachers.stream()
                .min(Comparator.comparingInt(Teacher::getTotal_sub_attended))
                .orElseThrow(() -> new RuntimeException("No teacher available"));
    }
    private String getPeriodValue(Timetable timetable, String period) {
        try {
            // Capitalize the period to match the method name (e.g., "p1" -> "P1")
            String methodName = "get" + period.substring(0, 1).toUpperCase() + period.substring(1);

            // Use reflection to get the method and invoke it
            Method method = Timetable.class.getMethod(methodName);

            // Log to confirm which method is being called
            System.out.println("Invoking method: " + methodName);

            Object result = method.invoke(timetable);

            // Check if result is null
            if (result == null) {
                System.out.println("No class assigned for " + period);
                return null;
            }

            return result.toString();
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
