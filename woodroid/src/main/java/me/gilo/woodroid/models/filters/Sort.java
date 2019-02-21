package me.gilo.woodroid.models.filters;

public enum Sort {

    ASCENDING{
        @Override
        public String toString() {
            return "asc";
        }
    },
    DESCENDING{
        @Override
        public String toString() {
            return "desc";
        }
    },
}
