package me.gilo.woodroid.data;

public enum ApiVersion {
    API_VERSION1{
        @Override
        public String toString() {
            return "1";
        }
    },
    API_VERSION2{
        @Override
        public String toString() {
            return "2";
        }
    },
    API_VERSION3{
        @Override
        public String toString() {
            return "3";
        }
    },
}