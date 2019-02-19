package me.gilo.woodroid.models.filters;

public class RefundFilter extends ListFilter{

    private int[] parent;
    private int[] parent_exclude;

    int dp;

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
        addFilter("parent", parent);
    }

    public int[] getParent_exclude() {
        return parent_exclude;
    }

    public void setParent_exclude(int[] parent_exclude) {
        this.parent_exclude = parent_exclude;

        addFilter("parent_exclude", parent_exclude);
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
        addFilter("dp", dp);

    }
}
