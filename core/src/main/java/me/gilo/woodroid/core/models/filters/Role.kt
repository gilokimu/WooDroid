package me.gilo.woodroid.models.filters

enum class Role {
    ALL {
        override fun toString(): String {
            return "all"
        }
    },
    ADMINISTRATOR {
        override fun toString(): String {
            return "administrator"
        }
    },
    EDITOR {
        override fun toString(): String {
            return "editor"
        }
    },

    AUTHOR {
        override fun toString(): String {
            return "author"
        }
    },

    CONTRIBUTOR {
        override fun toString(): String {
            return "contributor"
        }
    },

    SUBSCRIBER {
        override fun toString(): String {
            return "subscriber"
        }
    },

    CUSTOMER {
        override fun toString(): String {
            return "customer"
        }
    },

    SHOP_MANAGER {
        override fun toString(): String {
            return "shop_manager"
        }
    }
}
