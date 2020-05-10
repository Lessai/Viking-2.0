package com.dp.viking.domain.util;

import org.springframework.ui.Model;

public class EmployeeUtil {
    public void successResult(Model model){
        model.addAttribute("notificationMessage", "Данные о сотруднике были успешно сохранены (изменены)! Все выбранные документы сформированы.");
    }

    public void failureResult(Model model){
        model.addAttribute("notificationMessage", "Форма была заполнена некорректно, попробуйте еще раз.");
    }
}
