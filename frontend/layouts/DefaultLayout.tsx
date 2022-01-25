import React, {useState} from "react";
import {observer} from "mobx-react-lite";
import { useRouter } from 'next/router'

import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";

declare interface SidebarProps extends React.HTMLAttributes<HTMLDivElement> {
    children?: React.ReactNode
}

const SidebarLayout: React.FC<SidebarProps> = observer(({ children, ...HTMLElements}) => {
    const [sidebarExtended, setSidebarExtended] = useState(false)
    const router = useRouter()

    const toggleSidebar = () => {
        setSidebarExtended(!sidebarExtended)
    }

    return (
        <main>
            <Header toggleSidebar={toggleSidebar} />
            <div className="flex overflow-hidden h-screen text-gray-200 font-poppins">
                <Sidebar extended={sidebarExtended} pathName={router ? router.pathname : ""} toggleSidebar={toggleSidebar} />
                <div onClick={toggleSidebar} className={`${!sidebarExtended && 'hidden'} lg:hidden absolute z-10 w-full h-screen`} />
                <main className="flex overflow-auto flex-col w-full min-h-screen bg-dark-dark">
                    <div className="container flex-grow mx-auto mb-10">
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
