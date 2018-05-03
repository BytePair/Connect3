package com.bytepair.connect3;

enum Team {

    YELLOW (0, R.drawable.yellow),
    RED (1, R.drawable.red);

    private final int teamNumber;
    private final int resourceId;

    Team(int teamNumber, int resourceId) {
        this.teamNumber = teamNumber;
        this.resourceId = resourceId;
    }

    public int getTeamNumber() {
        return this.teamNumber;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public static Team nextTeam(Team team) {
        return Team.values()[(team.ordinal()+1)%Team.values().length];
    }

}
