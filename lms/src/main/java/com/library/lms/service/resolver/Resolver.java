package com.library.lms.service.resolver;

import com.library.lms.model.Transaction;

public interface Resolver {
    Transaction resolve(Transaction transaction);
}
