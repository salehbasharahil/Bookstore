package com.dxc.bookstore.domain;

import java.time.LocalDate;

public record Author (String name, LocalDate birthday) {
}
