import React, {useState} from "react";
import {observer} from "mobx-react-lite";
import { useRouter } from 'next/router'

import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";

declare interface SidebarLayoutProps extends React.HTMLAttributes<HTMLDivElement> {
    children?: React.ReactNode
}

const SidebarLayout = observer(({ children, ...HTMLElements}: SidebarLayoutProps) => {
    const [sidebarExtended, setSidebarExtended] = useState(false)
    const router = useRouter()

    const toggleSidebar = () => {
        setSidebarExtended(!sidebarExtended)
    }

    return (
        <main>
            <Header toggleSidebar={toggleSidebar} />
            <div className="flex overflow-hidden h-screen text-gray-700 dark:text-gray-200">
                <Sidebar extended={sidebarExtended} pathName={router ? router.pathname : ""} />
                <div onClick={toggleSidebar} className={`${!sidebarExtended && 'hidden'} lg:hidden absolute z-10 w-full h-screen`} />
                <main className="flex overflow-auto flex-col w-full min-h-screen bg-white dark:bg-bastille-400">
                    <div className="mt-20 flex-grow mx-7 mb-10">
                        <div {...HTMLElements} className={`flex-grow ${HTMLElements.className}`}>
                            {children}
                        </div>
                    </div>
                </main>
            </div>
        </main>
    )
});

export default SidebarLayout
