package com.zk;

public class ElfArmy implements Army {

    private static final String DESCRIPTION ="This is the Elven army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
