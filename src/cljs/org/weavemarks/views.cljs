(ns org.weavemarks.views
  (:require
   [re-frame.core :as re-frame]
   [org.weavemarks.subs :as subs]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Weavemarks"]
     [:h2 "Wallet"]
     [:p
      [:textarea]]
     [:p
      [:button "Use Wallet"]]
     [:h2 "New Bookmark"]
     [:h3 "URL"]
     [:input]
     [:h3 "Description"]
     [:input]
     [:h2 "Bookmarks"]
     ;; TODO add bookmark list
     ]))
