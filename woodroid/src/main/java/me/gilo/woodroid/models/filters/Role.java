package me.gilo.woodroid.models.filters;

public enum Role {
    ALL{
        @Override
        public String toString() {
            return "all";
        }
    },
    ADMINISTRATOR{
        @Override
        public String toString() {
            return "administrator";
        }
    },
    EDITOR{
        @Override
        public String toString() {
            return "editor";
        }
    },

    AUTHOR{
        @Override
        public String toString() {
            return "author";
        }
    },

    CONTRIBUTOR{
        @Override
        public String toString() {
            return "contributor";
        }
    },

    SUBSCRIBER{
        @Override
        public String toString() {
            return "subscriber";
        }
    },

    CUSTOMER{
        @Override
        public String toString() {
            return "customer";
        }
    },

    SHOP_MANAGER{
        @Override
        public String toString() {
            return "shop_manager";
        }
    },
}
