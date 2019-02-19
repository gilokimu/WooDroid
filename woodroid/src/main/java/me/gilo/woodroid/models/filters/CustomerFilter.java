package me.gilo.woodroid.models.filters;

public class CustomerFilter extends ListFilter{

    String email;
    String role;

    //all, administrator, editor, author, contributor, subscriber, customer and shop_manager

    enum Role {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        addFilter("email", email);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        addFilter("role", role);
    }

    public void setRole(Role role) {
        this.role = role.toString();
        addFilter("role", role.toString());
    }
}
