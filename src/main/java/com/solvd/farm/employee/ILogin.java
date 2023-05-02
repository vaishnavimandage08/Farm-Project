package com.solvd.farm.employee;

import java.time.LocalDateTime;

public interface ILogin {

    void checkIn(LocalDateTime timeIn);

    void checkOut(LocalDateTime timeOut);

}
