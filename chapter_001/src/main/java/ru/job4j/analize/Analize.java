package ru.job4j.analize;
import java.util.List;
import java.util.Objects;

public class Analize {


    public Info diff(List<User> previous, List<User> current) {
        int added = this.addUsers(previous, current);
        int changed = this.changedUsers(previous, current);
        return new Analize.Info(added, changed, previous.size() - added - changed);
    }

    public int addUsers(List<User> previous, List<User> current) {
        int added = 0;
        for (int left = 0; left != current.size() && left != previous.size(); left++) {
            if (previous.contains(current.get(left))) {
                added++;
            }
        }
        return added;
    }

    public int changedUsers(List<User> previous, List<User> current) {
        int changed = 0;
        for (int left = 0; left != previous.size(); left++) {
            for (int right = 0; right != current.size(); right++) {
                if (previous.get(left).name.equals(current.get(right).name) &&
                        previous.get(left).id != current.get(right).id) {
                    changed++;
                    break;
                }
            }
        }
        return changed;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
