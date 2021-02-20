(ns org.weavemarks.views
  (:require
   [org.weavemarks.events :as events]
   [org.weavemarks.subs :as subs]
   [re-frame.core :as re-frame]))

(defn main-panel []
  (let [arweave-address @(re-frame/subscribe [::subs/arweave-address])]
    [:div
     [:h1 "Weavemarks"]
     [:h2 "Wallet"]
     [:div
      [:strong "Arweave Address: "]
      (if arweave-address
        arweave-address
        "None")]
     [:p
      [:textarea
       {:on-change #(re-frame/dispatch [::events/update-wallet (-> % .-target .-value)])}]]
     [:p
      [:button
       {:on-click #(re-frame/dispatch [::events/init-wallet])}
       "Use Wallet"]]
     [:h2 "New Bookmark"]
     [:h3 "URL"]
     [:input]
     [:h3 "Description"]
     [:input]
     [:h2 "Bookmarks"]
     ;; TODO add bookmark list
     ]))
