import {
  createRouter,
  createWebHistory,
  useRoute,
  useRouter,
} from "vue-router";
import { ref } from "vue";

import HomeView from "../views/HomeView.vue";
import UserView from "@/views/UserView.vue";
import Profile from "@/components/Profile.vue";
import PostDetail from "@/components/PostDetail.vue";
import PostList from "@/components/PostList.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/about",
      name: "about",
      component: () => import("../views/AboutView.vue"),
    },
    {
      path: "/user/:username",
      name: "user",
      component: UserView,
      beforeEnter: (to, from) => {
        const userName = to.params.username;

        if (userName !== "admin") {
          window.alert("경고!!");
          return { name: "home" };
        }
      },

      children: [
        {
          path: "profile",
          name: "user-profile",
          component: Profile,
          children: [
            {
              path: "posts",
              name: "user-posts",
              component: PostList,
              children: [
                {
                  path: ":id",
                  name: "post-detail",
                  component: PostDetail,
                },
              ],
            },
          ],
        },
      ],
    },
  ],
});

export default router;
